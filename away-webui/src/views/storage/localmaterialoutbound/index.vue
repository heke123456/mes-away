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
            <el-form-item label="出库单编号" prop="deliveryNoteID">
              <el-input
                v-model="queryParams.deliveryNoteID"
                placeholder="请输入出库单编号"
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
            <el-form-item label="任务编号" prop="productionTasksID">
              <el-input
                v-model="queryParams.productionTasksID"
                placeholder="请输入任务编号"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="工艺编号" prop="processingTechnologyID">
              <el-input
                v-model="queryParams.processingTechnologyID"
                placeholder="请输入工艺编号"
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
          v-hasPermi="['storage:localmaterialoutbound:add']"
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
          v-hasPermi="['storage:localmaterialoutbound:edit']"
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
          v-hasPermi="['storage:localmaterialoutbound:remove']"
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
          v-hasPermi="['storage:localmaterialoutbound:export']"
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
      :data="localmaterialoutboundList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column
        label="出库单编号"
        align="center"
        prop="deliveryNoteID"
      />
      <el-table-column
        label="材料基础信息编号"
        align="center"
        prop="materialID"
      />
      <el-table-column
        label="任务编号"
        align="center"
        prop="productionTasksID"
      />
      <el-table-column
        label="工艺编号"
        align="center"
        prop="processingTechnologyID"
      />
      <el-table-column
        label="出库数量"
        align="center"
        prop="outboundQuantity"
      />
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
            v-hasPermi="['storage:localmaterialoutbound:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['storage:localmaterialoutbound:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['storage:localmaterialoutbound:remove']"
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

    <!-- 添加或修改本地材料出库对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
  

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="出库单编号" prop="deliveryNoteID">
              <el-select v-model="form.deliveryNoteID" placeholder="出库单编号">
                <el-option
                  v-for="item in outboundorders"
                  :key="item.deliveryNoteID"
                  :label="item.deliveryNoteID"
                  :value="item.deliveryNoteID"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
  
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="材料基础信息编号" prop="materialID">
              <el-select
                v-model="form.materialID"
                placeholder="材料基础信息编号"
              >
                <el-option
                  v-for="item in materials"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
 
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="任务编号" prop="productionTasksID">
              <el-select
                v-model="form.productionTasksID"
                placeholder="任务编号"
              >
                <el-option
                  v-for="item in productiontasks"
                  :key="item.id"
                  :label="item.id"
                  :value="item.id"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
 
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="工艺编号" prop="processingTechnologyID">
              <el-select
                v-model="form.processingTechnologyID"
                placeholder="工艺编号"
              >
                <el-option
                  v-for="item in processingtechnologys"
                  :key="item.id"
                  :label="item.id"
                  :value="item.id"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="出库数量" prop="outboundQuantity">
          <el-input
            v-model="form.outboundQuantity"
            placeholder="请输入出库数量"
          />
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
  listLocalmaterialoutbound,
  getLocalmaterialoutbound,
  delLocalmaterialoutbound,
  addLocalmaterialoutbound,
  updateLocalmaterialoutbound,
} from "@/api/storage/localmaterialoutbound";
import { listOutboundorder } from "@/api/storage/outboundorder"; //出库单
import { listMaterial } from "@/api/storage/material"; //材料基本信息
import { listProductiontasks } from "@/api/produce/productiontasks";
import { listProcessingtechnology } from "@/api/produce/processingtechnology";
export default {
  name: "Localmaterialoutbound",
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
      // 本地材料出库表格数据
      localmaterialoutboundList: [],
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
        deliveryNoteID: null,
        materialID: null,
        productionTasksID: null,
        processingTechnologyID: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        deliveryNoteID: [
          { required: true, message: "出库单编号不能为空", trigger: "blur" },
        ],
        materialID: [
          {
            required: true,
            message: "材料基础信息编号不能为空",
            trigger: "blur",
          },
        ],
        outboundQuantity: [
          { required: true, message: "出库数量不能为空", trigger: "blur" },
        ],
      },
      outboundorders: [], //出库单
      materials: [], //材料基本信息
      productiontasks: [], //生产任务
      processingtechnologys: [], //加工工艺
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询本地材料出库列表 */
    getList() {
      this.loading = true;
      listLocalmaterialoutbound(this.queryParams).then((response) => {
        this.localmaterialoutboundList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    //出库单
    getlistOutboundorder() {
      listOutboundorder({}).then((response) => {
        this.outboundorders = response.rows;
      });
    },
    //材料基本信息
    getlistMaterial() {
      listMaterial({}).then((response) => {
        this.materials = response.rows;
      });
    },
    //生产任务
    getlistProductiontasks() {
      listProductiontasks({}).then((response) => {
        this.productiontasks = response.rows;
      });
    },
    //加工工艺
    getlistProcessingtechnology() {
      listProcessingtechnology({}).then((response) => {
        this.processingtechnologys = response.rows;
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
        deliveryNoteID: null,
        materialID: null,
        productionTasksID: null,
        processingTechnologyID: null,
        outboundQuantity: null,
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
      this.getlistOutboundorder();
      this.getlistMaterial();
      this.getlistProductiontasks();
      this.getlistProcessingtechnology();
      this.isadd = true;
      this.open = true;
      this.title = "添加本地材料出库";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.getlistOutboundorder();
      this.getlistMaterial();
      this.getlistProductiontasks();
      this.getlistProcessingtechnology();
      this.isadd = false;
      const id = row.id || this.ids;
      getLocalmaterialoutbound(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改本地材料出库";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateLocalmaterialoutbound(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLocalmaterialoutbound(this.form).then((response) => {
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
        .confirm('是否确认删除本地材料出库编号为"' + ids + '"的数据项？')
        .then(function () {
          return delLocalmaterialoutbound(ids);
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
        "storage/localmaterialoutbound/export",
        {
          ...this.queryParams,
        },
        `localmaterialoutbound_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
