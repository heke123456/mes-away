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
            <el-form-item label="产品图号" prop="productID">
              <el-input
                v-model="queryParams.productID"
                placeholder="请输入产品图号"
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
          v-if="status == '0'"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['produce:detailproductwarehousing:add']"
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
          v-if="status == '0'"
          v-hasPermi="['produce:detailproductwarehousing:edit']"
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
          v-if="status == '0'"
          v-hasPermi="['produce:detailproductwarehousing:remove']"
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
          v-hasPermi="['produce:detailproductwarehousing:export']"
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
      :data="detailproductwarehousingList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        label="产品入库单编号"
        align="center"
        prop="warehouseEntryID"
      />
      <el-table-column label="产品图号" align="center" prop="productID" />
      <el-table-column label="入库数量" align="center" prop="receiptQuantity" />
      <el-table-column
        label="成品检验编号"
        align="center"
        prop="finishedProductInspectionID"
      />
      <el-table-column label="检测结果" align="center" prop="testResult">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.aw_quality_finishedproductinspection_status"
            :value="scope.row.testResult"
          />
        </template>
      </el-table-column>
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
            v-hasPermi="['produce:detailproductwarehousing:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-if="status == '0'"
            v-hasPermi="['produce:detailproductwarehousing:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            v-if="status == '0'"
            @click="handleDelete(scope.row)"
            v-hasPermi="['produce:detailproductwarehousing:remove']"
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

    <!-- 添加或修改产品入库详单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form
        ref="form"
        :disabled="view_open"
        :model="form"
        :rules="rules"
        label-width="80px"
      >
        <el-form-item label="产品入库单编号" prop="warehouseEntryID">
          <el-input
            disabled
            v-model="form.warehouseEntryID"
            placeholder="请输入产品入库单编号"
          />
        </el-form-item>
        <el-form-item label="产品图号" prop="productID">
          <el-select
            filterable
            v-model="form.productID"
            placeholder="请选择产品图号"
            @focus="getListproduct()"
          >
            <el-option
              v-for="(item, index) in productlist"
              :key="index"
              :label="item.id"
              :value="item.id"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="入库数量" prop="receiptQuantity">
          <el-input
            v-model="form.receiptQuantity"
            placeholder="请输入入库数量"
          />
        </el-form-item>
        <el-form-item label="成品检验编号" prop="finishedProductInspectionID">
          <el-select
            filterable
            v-model="form.finishedProductInspectionID"
            placeholder="请选择成品检验编号"
            @focus="getListfinishedproductinspection()"
          >
            <el-option
              v-for="(item, index) in finishedproductinspectionlist"
              :key="index"
              :label="item.name"
              :value="item.id"
              @click.native="setFinishedproductinspection(item.id)"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="检测结果" prop="testResult">
          <el-select
            disabled
            v-model="finishedproductinspection.testResult"
            placeholder="请选择检测结果"
          >
            <el-option
              v-for="dict in dict.type
                .aw_quality_finishedproductinspection_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="notes">
          <el-input v-model="form.notes" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div v-if="!view_open" slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listDetailproductwarehousing,
  getDetailproductwarehousing,
} from "@/api/produce/detailproductwarehousing";
import {
  listFinishedproductinspection,
  getFinishedproductinspection,
} from "@/api/quality/finishedproductinspection.js";
import {
  addProductstorage,
  updateProductstorage,
  delProductstorage,
} from "@/api/produce/productstorage.js";
import { listProduct } from "@/api/order/product.js";
import "@/assets/styles/away-element-ui-disabled.scss"; // away css

export default {
  name: "Detailproductwarehousing",
  dicts: ["aw_quality_finishedproductinspection_status"],
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
      // 产品入库详单表格数据
      detailproductwarehousingList: [],
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
        productID: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        warehouseEntryID: [
          {
            required: true,
            message: "产品入库单编号不能为空",
            trigger: "blur",
          },
        ],
        productID: [
          { required: true, message: "产品图号不能为空", trigger: "blur" },
        ],
        receiptQuantity: [
          { required: true, message: "入库数量不能为空", trigger: "blur" },
        ],
        finishedProductInspectionID: [
          { required: true, message: "成品检验不能为空", trigger: "blur" },
        ],
      },
      // 当前产品入库单
      warehouseEntryID: null,
      // 成品检验信息列表
      finishedproductinspectionlist: [],
      // 当前选中成品检验信息
      finishedproductinspection: {},
      // 产品信息列表
      productlist: [],
      status: "",
    };
  },
  created() {
    this.getExist();
  },
  methods: {
    async getExist() {
      this.warehouseEntryID = this.$route.query.id;
      this.status = this.$route.query.status;
      this.queryParams.warehouseEntryID = this.warehouseEntryID;
      this.getList();
    },
    /** 查询产品入库详单列表 */
    getList() {
      this.loading = true;
      listDetailproductwarehousing(this.queryParams).then((response) => {
        this.detailproductwarehousingList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询成品检验信息 */
    async getListfinishedproductinspection() {
      this.loading = true;
      let total = (await listFinishedproductinspection())["total"];

      listFinishedproductinspection({ pageSize: total }).then((response) => {
        this.finishedproductinspectionlist = response.rows;
        this.loading = false;
      });
    },
    /** 选中成品检验信息 */
    setFinishedproductinspection(id) {
      this.loading = true;
      getFinishedproductinspection(id).then((response) => {
        this.finishedproductinspection = response.data;
        this.loading = false;
      });
    },
    /** 产品信息列表 */
    async getListproduct() {
      this.loading = true;
      let total = (await listProduct())["total"];
      listProduct({ pageSize: total }).then((response) => {
        this.productlist = response.rows;
        this.loading = false;
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
        warehouseEntryID: this.warehouseEntryID,
        productID: null,
        receiptQuantity: null,
        finishedProductInspectionID: null,
        notes: null,
      };
      // 成品检验信息列表
      this.finishedproductinspectionlist = [];
      // 当前选中成品检验信息
      this.finishedproductinspection = {};
      // 产品信息列表
      this.productlist = [];
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
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getDetailproductwarehousing(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.view_open = true;
        this.title = "产品入库详单";
        if (this.form.finishedProductInspectionID != null) {
          this.setFinishedproductinspection(
            this.form.finishedProductInspectionID
          );
        }
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.open = true;
      this.view_open = false;
      this.title = "添加产品入库详单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getDetailproductwarehousing(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.view_open = false;
        this.title = "修改产品入库详单";
        if (this.form.finishedProductInspectionID != null) {
          this.setFinishedproductinspection(
            this.form.finishedProductInspectionID
          );
        }
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateProductstorage(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProductstorage(this.form).then((response) => {
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
        .confirm('是否确认删除产品入库详单编号为"' + ids + '"的数据项？')
        .then(function () {
          return delProductstorage(ids);
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
        "produce/detailproductwarehousing/export",
        {
          ...this.queryParams,
        },
        `detailproductwarehousing_${new Date().getTime()}.xlsx`
      );
    },
  },
  watch: {
    "$route.query.id": {
      immediate: true,
      handler() {
        this.getExist();
      },
    },
  },
};
</script>
