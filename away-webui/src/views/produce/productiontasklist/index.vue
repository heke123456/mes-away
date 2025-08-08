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
      <el-form-item label="制单人" prop="founder">
        <el-input
          v-model="queryParams.founder"
          placeholder="请输入制单人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建日期" prop="createTime">
        <el-date-picker
          clearable
          v-model="queryParams.createTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择创建日期"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="备注信息" prop="notes">
        <el-input
          v-model="queryParams.notes"
          placeholder="请输入备注信息"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
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
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['produce:productiontasklist:add']"
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
          v-hasPermi="['produce:productiontasklist:edit']"
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
          v-hasPermi="['produce:productiontasklist:remove']"
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
          v-hasPermi="['produce:productiontasklist:export']"
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
      :data="productiontasklistList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="生产任务单编号" align="center" prop="id" />
      <el-table-column label="生产任务单简称" align="center" prop="referred" />
      <el-table-column label="制单人" align="center" prop="founder" />
      <el-table-column
        label="创建日期"
        align="center"
        prop="createTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注信息" align="center" prop="notes" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.aw_produce_form_status"
            :value="scope.row.status"
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
            v-hasPermi="['produce:productiontasklist:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['produce:productiontasklist:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['produce:productiontasklist:remove']"
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

    <!-- 添加或修改生产任务单对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="open"
      width="1600px"
      append-to-body
    >
      <el-form
        ref="form"
        :model="form"
        :rules="rules"
        label-width="80px"
        :disabled="open_view ? true : false"
      >
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="制单人" prop="founder">
              <div>{{ form.founder }}</div>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="订单状态" prop="state">
              <el-select
                v-model="form.status"
                value-key="value"
                placeholder="请选择订单状态"
              >
                <el-option
                  v-for="dict in dict.type.aw_produce_form_status"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="12">
          <el-col :span="6">
            <el-form-item label="简称" prop="referred">
              <el-input v-model="form.referred" placeholder="请输入简称" />
            </el-form-item>
          </el-col>
        </el-row>
        <productiontasksDialog
          v-if="open"
          :proformid="form.id"
          ref="productiontasksDialog"
        />

        <el-form-item label="备注信息" prop="notes">
          <el-input v-model="form.notes" placeholder="请输入备注信息" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" v-if="!open_view">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listProductiontasklist,
  getProductiontasklist,
  delProductiontasklist,
  addProductiontasklist,
  updateProductiontasklist,
} from "@/api/produce/productiontasklist";
import { removeByProductionTasksFormIDs } from "@/api/produce/productiontasks";
import ProductiontasksDialog from "./components/productiontasksDialog/index";

export default {
  name: "Productiontasklist",
  components: { productiontasksDialog: ProductiontasksDialog },
  dicts: ["aw_produce_form_status", "aw_produce_outsource_status"],
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
      // 生产任务单表格数据
      productiontasklistList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示查看弹出层
      open_view: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: "",
        founder: null,
        createTime: null,
        notes: null,
        status: null,
      },
      // 是否外协
      isoutsourced: [
        { key: "0", value: "否" },
        { key: "1", value: "是" },
      ],
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        referred: [
          { required: true, message: "任务单简称不能为空", trigger: "blur" },
        ],
        founder: [
          { required: true, message: "制单人不能为空", trigger: "blur" },
        ],
        createTime: [
          { required: true, message: "创建日期不能为空", trigger: "blur" },
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "change" },
        ],
      },
      // 生产任务列表
      productiontasks_list: [],
      // 删除任务队列
      del_productiontasks_list: [],
      // 销售订单表单
      saleorder_list: [],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询生产任务单列表 */
    getList() {
      this.loading = true;
      listProductiontasklist(this.queryParams).then((response) => {
        this.productiontasklistList = response.rows;
        this.total = response.total;
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
        founder: this.$store.state.user.name,
        createTime: null,
        notes: null,
        status: "0",
      };
      this.open_view = false;
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
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加生产任务单";
    },
    /** 修改按钮操作 */
    async handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      let response = await getProductiontasklist(id);
      this.form = response.data;
      this.open = true;
      this.title = "修改生产任务单";
    },
    /** 查看按钮操作 */
    async handleView(row) {
      this.reset();
      const id = row.id || this.ids;
      let response = await getProductiontasklist(id);
      this.form = response.data;
      this.open = true;
      this.open_view = true;
      this.title = "查看生产任务单";
    },
    /** 提交按钮 */
    async submitForm() {
      let productiontaskslist_id = null;
      await this.$refs["form"].validate(async (valid) => {
        if (valid) {
          if (this.form.id != null) {
            let response = await updateProductiontasklist(this.form);
            console.log(JSON.stringify(response));
            this.$modal.msgSuccess("修改成功");
            productiontaskslist_id = response.id;
            this.open = false;
            this.getList();
          } else {
            let response = await addProductiontasklist(this.form);
            console.log(JSON.stringify(response));
            this.$modal.msgSuccess("新增成功");
            productiontaskslist_id = response.id;
            this.open = false;
            this.getList();
          }
          this.$refs.productiontasksDialog.produceformid =
            productiontaskslist_id;
          this.$refs.productiontasksDialog.submitForm();
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal
        .confirm('是否确认删除生产任务单编号为"' + ids + '"的数据项？')
        .then(function () {
          return delProductiontasklist(ids);
        })
        .then((response) => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        })
        .catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download(
        "produce/productiontasklist/export",
        {
          ...this.queryParams,
        },
        `productiontasklist_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
<style scoped>
.productiontasks_list_box {
  max-height: 400px;
  overflow-y: auto;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
</style>
