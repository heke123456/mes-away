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
            <el-form-item label="委外类型" prop="outsourcingType">
              <el-select
                v-model="queryParams.outsourcingType"
                placeholder="请选择委外类型"
                clearable
              >
                <el-option
                  v-for="dict in dict.type.aw_order_outsourcingorder_type"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                />
              </el-select>
            </el-form-item>
            <el-form-item label="下单时间" prop="orderTime">
              <el-date-picker
                clearable
                v-model="queryParams.orderTime"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择下单时间"
              >
              </el-date-picker>
            </el-form-item>
            <el-form-item label="备注" prop="notes">
              <el-input
                v-model="queryParams.notes"
                placeholder="请输入备注"
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
          v-hasPermi="['order:outsourcingorder:add']"
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
          v-hasPermi="['order:outsourcingorder:edit']"
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
          v-hasPermi="['order:outsourcingorder:remove']"
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
          v-hasPermi="['order:outsourcingorder:export']"
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
      :data="outsourcingorderList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        label="外协单编号"
        align="center"
        prop="outsourcingOrderID"
      />
      <el-table-column
        label="任务单编号"
        align="center"
        prop="productionTasksFormID"
      />
      <el-table-column
        label="任务编号"
        align="center"
        prop="productionTasksID"
      />
      <el-table-column
        label="工序编号"
        align="center"
        prop="processingprocessID"
      />
      <el-table-column label="委外类型" align="center" prop="outsourcingType">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.aw_order_outsourcingorder_type"
            :value="scope.row.outsourcingType"
          />
        </template>
      </el-table-column>
      <el-table-column
        label="下单时间"
        align="center"
        prop="orderTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.orderTime, "{y}-{m}-{d}") }}</span>
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
            v-hasPermi="['order:outsourcingorder:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['order:outsourcingorder:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['order:outsourcingorder:remove']"
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

    <!-- 添加或修改外协对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form
        :disabled="view_open"
        ref="form"
        :model="form"
        :rules="rules"
        label-width="80px"
      >
        <el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="外协单编号" prop="outsourcingOrderID">
              <el-input
                :disabled="!isadd"
                v-model="form.outsourcingOrderID"
                placeholder="请输入外协单编号"
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="委外类型" prop="outsourcingType">
              <el-select
                v-model="form.outsourcingType"
                placeholder="请选择委外类型"
              >
                <el-option
                  v-for="dict in dict.type.aw_order_outsourcingorder_type"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select> </el-form-item></el-col
        ></el-row>
        <el-row :gutter="12"
          ><el-col :span="12"
            ><el-form-item label="任务单" prop="productionTasksFormID">
              <el-select
                filterable
                v-model="form.productionTasksFormID"
                placeholder="请选择任务单"
                @focus="getListproductiontasklist()"
              >
                <el-option
                  v-for="(item, index) in productiontasklistlist"
                  :key="index"
                  :label="item.referred"
                  :value="item.id"
                  @click.native="setProductiontasklist(item.id)"
                >
                </el-option>
              </el-select> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="任务编号" prop="productionTasksID">
              <el-select
                filterable
                :disabled="
                  productiontasklist.id == null || form.outsourcingType == null
                "
                v-model="form.productionTasksID"
                placeholder="请选择任务"
                @focus="getListproductiontasks(productiontasklist.id)"
              >
                <el-option
                  v-for="(item, index) in productiontaskslist"
                  :key="index"
                  :label="item.id"
                  :value="item.id"
                  @click.native="setProductiontasks(item.id)"
                >
                </el-option>
              </el-select> </el-form-item></el-col
        ></el-row>
        <el-row :gutter="12"
          ><el-col :span="12"
            ><el-form-item
              v-if="form.outsourcingType == 1"
              label="工序编号"
              prop="processingprocessID"
            >
              <el-select
                filterable
                :disabled="productionTasks.processingTechnologyID == null"
                v-model="form.processingprocessID"
                placeholder="请选择工序编号"
                @focus="
                  getListprocessingprocess(
                    productionTasks.processingTechnologyID
                  )
                "
              >
                <el-option
                  v-for="(item, index) in processingprocesslist"
                  :key="index"
                  :label="item.name"
                  :value="item.id"
                >
                </el-option>
              </el-select> </el-form-item></el-col
        ></el-row>
        <el-row :gutter="12"
          ><el-col :span="12"
            ><el-form-item label="下单时间" prop="orderTime">
              <el-date-picker
                clearable
                v-model="form.orderTime"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择下单时间"
              >
              </el-date-picker> </el-form-item></el-col
        ></el-row>
        <el-row :gutter="12"
          ><el-col :span="24"
            ><el-form-item label="备注" prop="notes">
              <el-input
                v-model="form.notes"
                placeholder="请输入备注"
              /> </el-form-item></el-col
        ></el-row>
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
  listOutsourcingorder,
  getOutsourcingorder,
  delOutsourcingorder,
  addOutsourcingorder,
  updateOutsourcingorder,
} from "@/api/order/outsourcingorder";
import {
  listProductiontasklist,
  getProductiontasklist,
} from "@/api/produce/productiontasklist.js";
import {
  listProductiontasks,
  getProductiontasks,
} from "@/api/produce/productiontasks.js";
import {
  listProcessingprocess,
  getProcessingprocess,
} from "@/api/produce/processingprocess.js";
import "@/assets/styles/away-element-ui-disabled.scss"; // away css

export default {
  name: "Outsourcingorder",
  dicts: ["aw_order_outsourcingorder_type"],
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
      // 外协表格数据
      outsourcingorderList: [],
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
        outsourcingType: null,
        orderTime: null,
        notes: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        outsourcingOrderID: [
          { required: true, message: "外协单编号不能为空", trigger: "blur" },
        ],
        productionTasksFormID: [
          { required: true, message: "任务单编号不能为空", trigger: "blur" },
        ],
        productionTasksID: [
          { required: true, message: "任务编号不能为空", trigger: "blur" },
        ],
        outsourcingType: [
          { required: true, message: "委外类型不能为空", trigger: "change" },
        ],
        processingprocessID: [
          { required: true, message: "工序编号不能为空", trigger: "change" },
        ],
        orderTime: [
          { required: true, message: "下单时间不能为空", trigger: "blur" },
        ],
      },
      // 选中任务单
      productiontasklist: {},
      // 选中任务
      productionTasks: {},
      // 任务单信息
      productiontasklistlist: [],
      // 任务信息
      productiontaskslist: [],
      // 工序信息
      processingprocesslist: [],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询外协列表 */
    getList() {
      this.loading = true;
      listOutsourcingorder(this.queryParams).then((response) => {
        this.outsourcingorderList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询任务单信息 */
    async getListproductiontasklist() {
      this.loading = true;
      let total = (await listProductiontasklist())["total"];

      listProductiontasklist({ pageSize: total, status: "1" }).then(
        (response) => {
          this.productiontasklistlist = response.rows;
          console.log(this.productiontasklistlist);
          this.loading = false;
        }
      );
    },
    setProductiontasklist(id) {
      getProductiontasklist(id).then((response) => {
        this.productiontasklist = response.data;
      });
    },
    /** 查询任务信息 */
    getListproductiontasks(productionTasksFormID) {
      let tasksQues = { productionTasksFormID: productionTasksFormID };
      if (this.form.outsourcingType == "0") {
        tasksQues.outsourced = "1";
      } else {
      }
      this.loading = true;
      listProductiontasks(tasksQues).then((response) => {
        this.productiontaskslist = response.rows;
        this.loading = false;
      });
    },
    setProductiontasks(id) {
      getProductiontasks(id).then((response) => {
        this.productionTasks = response.data;
      });
    },
    /** 查询工序信息 */
    async getListprocessingprocess(processingTechnologyID) {
      this.loading = true;
      let total = (
        await listProcessingprocess({
          processingTechnologyID: processingTechnologyID,
          outsourcing: 1,
        })
      )["total"];
      listProcessingprocess({
        processingTechnologyID: processingTechnologyID,
        outsourcing: 1,
        pageSize: total,
      }).then((response) => {
        this.processingprocesslist = response.rows;
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
        outsourcingOrderID: null,
        productionTasksFormID: null,
        productionTasksID: null,
        processingprocessID: null,
        outsourcingType: null,
        orderTime: null,
        notes: null,
      };
      // 选中任务单
      this.productiontasklist = {};
      // 选中任务
      this.productionTasks = {};
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
      this.ids = selection.map((item) => item.outsourcingOrderID);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    handleView(row) {
      this.reset();
      this.isadd = false;
      const outsourcingOrderID = row.outsourcingOrderID || this.ids;
      getOutsourcingorder(outsourcingOrderID).then((response) => {
        this.form = response.data;
        this.view_open = true;
        this.getListproductiontasklist();
        this.open = true;
        this.title = "修改外协";
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.view_open = false;
      this.open = true;
      this.title = "添加外协";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const outsourcingOrderID = row.outsourcingOrderID || this.ids;
      getOutsourcingorder(outsourcingOrderID).then((response) => {
        this.form = response.data;
        this.view_open = false;
        this.getListproductiontasklist();
        this.open = true;
        this.title = "修改外协";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateOutsourcingorder(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOutsourcingorder(this.form).then((response) => {
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
      const outsourcingOrderIDs = row.outsourcingOrderID || this.ids;
      this.$modal
        .confirm(
          '是否确认删除外协编号为"' + outsourcingOrderIDs + '"的数据项？'
        )
        .then(function () {
          return delOutsourcingorder(outsourcingOrderIDs);
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
        "order/outsourcingorder/export",
        {
          ...this.queryParams,
        },
        `outsourcingorder_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
