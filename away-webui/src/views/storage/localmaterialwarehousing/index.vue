<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <el-row :gutter="1">
        <el-col :span="21">
          <div
            style="overflow-x: auto; scrollbar-width: none; white-space: nowrap"
          >
            <el-form-item label="入库单编号" prop="warehouseEntryID">
              <el-input
                v-model="queryParams.warehouseEntryID"
                placeholder="请输入入库单编号"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="申购材料编号" prop="materialSubscription">
              <el-input
                v-model="queryParams.materialSubscription"
                placeholder="请输入申购材料编号"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="发票信息编号" prop="receiptInvoiceID">
              <el-input
                v-model="queryParams.receiptInvoiceID"
                placeholder="请输入发票信息编号"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="材料基础信息编号" prop="materialID">
              <el-input
                v-model="queryParams.materialID"
                placeholder="请输入材料基础信息编号"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="3">
          <el-form-item>
            <el-button
              type="primary"
              icon="el-icon-search"
              size="mini"
              @click="handleQuery"
              >搜索</el-button
            >
            <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
              >重置</el-button
            >
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['storage:localmaterialwarehousing:add']"
          >新增</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['storage:localmaterialwarehousing:edit']"
          >修改</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['storage:localmaterialwarehousing:remove']"
          >删除</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['storage:localmaterialwarehousing:export']"
          >导出</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="localmaterialwarehousingList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column
        label="入库单编号"
        align="center"
        prop="warehouseEntryID"
      />
      <el-table-column
        label="申购材料编号"
        align="center"
        prop="materialSubscription"
      />
      <el-table-column
        label="发票信息编号"
        align="center"
        prop="receiptInvoiceID"
      />
      <el-table-column
        label="材料基础信息编号"
        align="center"
        prop="materialID"
      />
      <el-table-column label="入库数量" align="center" prop="receiptQuantity" />
      <el-table-column label="附样" align="center" prop="sampleURL" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.sampleURL" :width="50" :height="50" />
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="notes" />
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleView(scope.row)"
            v-hasPermi="['storage:localmaterialwarehousing:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['storage:localmaterialwarehousing:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['storage:localmaterialwarehousing:remove']"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改本地材料入库对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <!-- <el-form-item label="入库单编号" prop="warehouseEntryID">
          <el-input v-model="form.warehouseEntryID" placeholder="请输入入库单编号" />
        </el-form-item> -->
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="入库单编号" prop="warehouseEntryID">
              <el-select
                v-model="form.warehouseEntryID"
                placeholder="入库单编号"
              >
                <el-option
                  v-for="item in warehousings"
                  :key="item.warehouseEntryID"
                  :label="item.warehouseEntryID"
                  :value="item.warehouseEntryID"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- <el-form-item label="申购材料编号" prop="materialSubscription">
          <el-input v-model="form.materialSubscription" placeholder="请输入申购材料编号" />
        </el-form-item> -->

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="申购材料编号" prop="materialSubscription">
              <el-select
                v-model="form.materialSubscription"
                placeholder="申购材料编号"
              >
                <el-option
                  v-for="item in materialsubscriptions"
                  :key="item.materialSubscription"
                  :label="item.materialSubscription"
                  :value="item.materialSubscription"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <!-- <el-form-item label="发票信息编号" prop="receiptInvoiceID">
          <el-input v-model="form.receiptInvoiceID" placeholder="请输入发票信息编号" />
        </el-form-item> -->
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="发票信息编号" prop="receiptInvoiceID">
              <el-select
                v-model="form.receiptInvoiceID"
                placeholder="发票信息编号"
              >
                <el-option
                  v-for="item in receiptinvoices"
                  :key="item.receiptInvoiceID"
                  :label="item.receiptInvoiceID"
                  :value="item.receiptInvoiceID"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- <el-form-item label="材料基础信息编号" prop="materialID">
          <el-input
            v-model="form.materialID"
            placeholder="请输入材料基础信息编号"
          />
        </el-form-item> -->

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="材料基础信息编号" prop="materialID">
              <el-select
                v-model="form.materialID"
                placeholder="材料基础信息编号"
              >
                <el-option
                  v-for="item in Materials"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="入库数量" prop="receiptQuantity">
          <el-input
            v-model="form.receiptQuantity"
            placeholder="请输入入库数量"
          />
        </el-form-item>
        <el-form-item label="附样" prop="sampleURL">
          <image-upload v-model="form.sampleURL" />
        </el-form-item>
        <el-form-item label="备注" prop="notes">
          <el-input v-model="form.notes" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listLocalmaterialwarehousing,
  getLocalmaterialwarehousing,
  delLocalmaterialwarehousing,
  addLocalmaterialwarehousing,
  updateLocalmaterialwarehousing,
} from "@/api/storage/localmaterialwarehousing";
import { listWarehousing } from "@/api/storage/warehousing";
import { listReceiptinvoice } from "@/api/finance/receiptinvoice";
import { listMaterialsubscription } from "@/api/order/materialsubscription";
import { listMaterial } from "@/api/storage/material";
export default {
  name: "Localmaterialwarehousing",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 本地材料入库表格数据
      localmaterialwarehousingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示查看窗口
      view_open: false,
      // 是否新增
      isadd: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        warehouseEntryID: null,
        materialSubscription: null,
        receiptInvoiceID: null,
        materialID: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        warehouseEntryID: [
          { required: true, message: "入库单编号不能为空", trigger: "blur" },
        ],
        receiptInvoiceID: [
          { required: true, message: "发票信息编号不能为空", trigger: "blur" },
        ],
        materialID: [
          {
            required: true,
            message: "材料基础信息编号不能为空",
            trigger: "blur",
          },
        ],
        receiptQuantity: [
          { required: true, message: "入库数量不能为空", trigger: "blur" },
        ],
      },
      //入库单编号
      warehousings: [],
      //入库发票
      receiptinvoices: [],
      //申购材料
      materialsubscriptions: [],
      //材料基础信息
      Materials: [],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询本地材料入库列表 */
    getList() {
      this.loading = true;
      listLocalmaterialwarehousing(this.queryParams).then((response) => {
        this.localmaterialwarehousingList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },

    //查询入库单编号
    getlistWarehousing() {
      listWarehousing({}).then((response) => {
        this.warehousings = response.rows;
      });
    },
    //查询入库发票
    getlistReceiptinvoice() {
      listReceiptinvoice({}).then((response) => {
        this.receiptinvoices = response.rows;
      });
    },

    //查询申购材料
    getlistMaterialsubscription() {
      listMaterialsubscription({}).then((response) => {
        this.materialsubscriptions = response.rows;
      });
    },

    //查询材料基础信息
    getlistMaterial() {
      listMaterial({}).then((response) => {
        this.Materials = response.rows;
      });
    },

    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        warehouseEntryID: null,
        materialSubscription: null,
        receiptInvoiceID: null,
        materialID: null,
        receiptQuantity: null,
        sampleURL: null,
        notes: null,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.id);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    handleView(row) {
      this.view_open = true;
    },

    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.getlistWarehousing(); //入库单编号
      this.getlistReceiptinvoice(); //发票
      this.getlistMaterialsubscription(); //查询申购材料
      this.getlistMaterial(); //查询材料基础信息
      this.isadd = true;
      this.open = true;
      this.title = "添加本地材料入库";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.getlistWarehousing(); //入库单编号
      this.getlistReceiptinvoice(); //发票
      this.getlistMaterialsubscription(); //查询申购材料
      this.getlistMaterial(); //查询材料基础信息
      this.isadd = false;
      const id = row.id || this.ids;
      getLocalmaterialwarehousing(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改本地材料入库";
      });
    },

    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateLocalmaterialwarehousing(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLocalmaterialwarehousing(this.form).then((response) => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal
        .confirm('是否确认删除本地材料入库编号为"' + ids + '"的数据项？')
        .then(function () {
          return delLocalmaterialwarehousing(ids);
        })
        .then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        })
        .catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download(
        "storage/localmaterialwarehousing/export",
        {
          ...this.queryParams,
        },
        `localmaterialwarehousing_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
