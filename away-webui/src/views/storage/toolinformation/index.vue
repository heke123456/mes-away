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
      <el-form-item label="刀具名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入刀具名称"
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
          v-hasPermi="['storage:toolinformation:add']"
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
          v-hasPermi="['storage:toolinformation:edit']"
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
          v-hasPermi="['storage:toolinformation:remove']"
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
          v-hasPermi="['storage:toolinformation:export']"
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
      :data="toolinformationList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="刀具编号" align="center" prop="id" />
      <el-table-column label="刀具名称" align="center" prop="name" />
      <el-table-column label="刀具分类" align="center" prop="type" />
      <el-table-column label="刀具规格" align="center" prop="specification" />
      <el-table-column label="计量单位" align="center" prop="unit" />
      <el-table-column label="价格" align="center" prop="notes" />
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
            v-hasPermi="['storage:toolinformation:query']"
            >查看</el-button
          >

          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['storage:toolinformation:edit']"
            >修改</el-button
          >

          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['storage:toolinformation:remove']"
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

    <!-- 添加或修改刀具信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form
        ref="form"
        :model="form"
        :rules="rules"
        label-width="80px"
        :disabled="view_open"
      >
        <el-form-item v-if="isadd" label="刀具编号" prop="id">
          <el-input v-model="form.id" placeholder="请输入刀具编号" />
        </el-form-item>
        <el-form-item label="刀具名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入刀具名称" />
        </el-form-item>
        <el-form-item label="刀具分类" prop="typeID">
          <el-select v-model="form.typeID" placeholder="请选择刀具分类">
            <el-option
              v-for="item in formtypes"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="刀具规格" prop="specificationsID">
          <el-select
            v-model="form.specificationsID"
            placeholder="请输入刀具规格"
          >
            <el-option
              v-for="item in formspecifications"
              :key="item.id"
              :label="item.type"
              :value="item.id"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="计量单位" prop="unitID">
          <el-select v-model="form.unitID" placeholder="请选择计量单位">
            <el-option
              v-for="item in formunits"
              :key="item.id"
              :label="item.unit"
              :value="item.id"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="价格" prop="notes">
          <el-input v-model="form.notes" placeholder="请输入价格" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" v-if="!view_open">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listToolinformation,
  getToolinformation,
  delToolinformation,
  addToolinformation,
  updateToolinformation,
} from "@/api/storage/toolinformation";
import { listToolclassification } from "@/api/storage/toolclassification";
import { listUnits } from "@/api/storage/units";
import { listSpecifications } from "@/api/storage/specifications";

export default {
  name: "Toolinformation",
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
      // 刀具信息表格数据
      toolinformationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否新建
      isadd: true,
      view_open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        typeID: null,
        specificationsID: null,
        unitID: null,
        notes: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [{ required: true, message: "刀具编号不能为空", trigger: "blur" }],
        name: [
          { required: true, message: "刀具名称不能为空", trigger: "blur" },
        ],
        typeID: [
          { required: true, message: "刀具分类不能为空", trigger: "blur" },
        ],
        specificationsID: [
          { required: true, message: "刀具规格不能为空", trigger: "blur" },
        ],
        unitID: [
          { required: true, message: "计量单位id不能为空", trigger: "blur" },
        ],
        notes: [{ required: true, message: "价格不能为空", trigger: "blur" }],
      },
      // 刀具分类参数
      formtypes: [],
      // 计量单位参数
      formunits: [],
      // 规格参数
      formspecifications: [],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询刀具信息列表 */
    getList() {
      this.loading = true;
      listToolinformation(this.queryParams).then((response) => {
        this.toolinformationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询刀具分类信息 **/
    async getlistToolclassification() {
      let total = (await listToolclassification())["total"];

      console.log(total);
      listToolclassification({ pageSize: total }).then((response) => {
        this.formtypes = response.rows;
      });
    },
    /** 查询单位信息 **/
    async getlistUnits() {
      let total = (await listUnits())["total"];
      listUnits({ pageSize: total }).then((response) => {
        this.formunits = response.rows;
      });
    },
    /** 查询规格信息 **/
    async getlistSpecifications() {
      let total = (await listSpecifications())["total"];
      listSpecifications({ pageSize: total }).then((response) => {
        this.formspecifications = response.rows;
      });
    },
    /** 查询相关维度表 **/
     getUnList() {
      this.getlistToolclassification();
      this.getlistUnits();
      this.getlistSpecifications();
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
        name: null,
        typeID: null,
        specificationsID: null,
        unitID: null,
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
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.view_open = false;
      this.getUnList();
      this.isadd = true;
      this.open = true;
      this.title = "添加刀具信息";
    },

    handleView(row) {
      this.view_open = true;
      this.reset();
      this.getUnList();
      this.isadd = false;
      const id = row.id || this.ids;
      getToolinformation(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "查看刀具信息";
      });
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.view_open = false;
      this.getUnList();
      this.isadd = false;
      const id = row.id || this.ids;
      getToolinformation(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改刀具信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateToolinformation(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addToolinformation(this.form).then((response) => {
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
        .confirm('是否确认删除刀具信息编号为"' + ids + '"的数据项？')
        .then(function () {
          return delToolinformation(ids);
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
        "storage/toolinformation/export",
        {
          ...this.queryParams,
        },
        `toolinformation_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
