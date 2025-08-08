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
            <el-form-item label="刀具姓名" prop="name">
              <el-input
                v-model="queryParams.name"
                placeholder="请输入刀具姓名"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="数量" prop="number">
              <el-input
                v-model="queryParams.number"
                placeholder="请输入数量"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="重量" prop="weight">
              <el-input
                v-model="queryParams.weight"
                placeholder="请输入重量"
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
          v-hasPermi="['storage:LocalTool:add']"
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
          v-hasPermi="['storage:LocalTool:edit']"
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
          v-hasPermi="['storage:LocalTool:remove']"
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
          v-hasPermi="['storage:LocalTool:export']"
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
      :data="LocalToolList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="库存id" align="center" prop="id" />
      <el-table-column label="刀具名称" align="center" prop="name" />
      <el-table-column label="刀具价格" align="center" prop="notes" />
      <el-table-column label="数量" align="center" prop="number" />
      <el-table-column label="重量" align="center" prop="weight" />
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
            v-hasPermi="['storage:LocalTool:query']"
            >查看</el-button
          >

          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['storage:LocalTool:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['storage:LocalTool:remove']"
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
    <!-- 添加或修改刀具库存对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form
        ref="form"
        :model="form"
        :rules="rules"
        label-width="80px"
        :disabled="view_open"
      >
        <el-form-item label="刀具基本信息" prop="toolInformationID">
          <el-select
            v-model="form.toolInformationID"
            placeholder="请选择刀具基本信息"
            @focus="getToolinformationList()"
          >
            <el-option
              @click.native="setToolinformation(item.id)"
              v-for="item in toolInformationList"
              :key="item.id"
              :label="item.id"
              :value="item.id"
            >
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="刀具名称">
          <el-input
            v-model="toolInformation.name"
            disabled
            placeholder="请输入刀具名称"
          />
        </el-form-item>

        <el-form-item label="刀具价格">
          <el-input
            v-model="toolInformation.notes"
            disabled
            placeholder="请输入刀具价格"
          />
        </el-form-item>

        <el-form-item label="数量" prop="number">
          <el-input v-model="form.number" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="重量" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入重量" />
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
  listLocalTool,
  getLocalTool,
  delLocalTool,
  addLocalTool,
  updateLocalTool,
} from "@/api/storage/LocalTool";
import {
  listToolinformation,
  getToolinformation,
} from "@/api/storage/toolinformation";

export default {
  name: "LocalTool",
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
      // 刀具库存表格数据
      LocalToolList: [],
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
        toolInformationID: null,
        number: null,
        weight: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
      toolInformationList: [],
      toolInformation: {},
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询刀具库存列表 */
    getList() {
      this.loading = true;
      listLocalTool(this.queryParams).then((response) => {
        this.LocalToolList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    //获取刀具基本信息
    getToolinformationList() {
      listToolinformation().then((response) => {
        this.toolInformationList = response.rows;
      });
    },

    setToolinformation(id) {
      getToolinformation(id).then((response) => {
        this.toolInformation = response.data;
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
        toolInformationID: null,
        number: null,
        weight: null,
      };
      this.resetForm("form");

      (this.toolInformationList = []), (this.toolInformation = {});
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
      this.isadd = true;
      this.open = true;
      this.title = "添加刀具库存";
    },

    handleView(row) {
      this.reset();
      this.view_open = true;
      this.isadd = false;
      const id = row.id || this.ids;
      getLocalTool(id).then((response) => {
        this.form = response.data;
        console.log(row);
        getToolinformation(row.toolInformationID).then((response) => {
          this.toolInformation = response.data;

          console.log(response);
        });

        this.open = true;
        this.title = "查看刀具库存";
      });
    },

    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.view_open = false;
      this.isadd = false;
      const id = row.id || this.ids;
      getLocalTool(id).then((response) => {
        this.form = response.data;
        console.log(row);
        getToolinformation(row.toolInformationID).then((response) => {
          this.toolInformation = response.data;

          console.log(response);
        });

        this.open = true;
        this.title = "修改刀具库存";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateLocalTool(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLocalTool(this.form).then((response) => {
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
        .confirm('是否确认删除刀具库存编号为"' + ids + '"的数据项？')
        .then(function () {
          return delLocalTool(ids);
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
        "storage/LocalTool/export",
        {
          ...this.queryParams,
        },
        `LocalTool_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
