<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
    <el-row :gutter="1">
            <el-col :span="21">
              <div style="overflow-x: auto;scrollbar-width: none; white-space: nowrap;">
      <el-form-item label="刀具名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入刀具名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="刀具分类" prop="typeID">
        <el-input
          v-model="queryParams.typeID"
          placeholder="请输入刀具分类"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="刀具规格" prop="specificationsID">
        <el-input
          v-model="queryParams.specificationsID"
          placeholder="请输入刀具规格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="计量单位id" prop="unitID">
        <el-input
          v-model="queryParams.unitID"
          placeholder="请输入计量单位id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注信息" prop="notes">
        <el-input
          v-model="queryParams.notes"
          placeholder="请输入备注信息"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类别名称" prop="typeName">
        <el-input
          v-model="queryParams.typeName"
          placeholder="请输入类别名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="计量单位" prop="uint">
        <el-input
          v-model="queryParams.uint"
          placeholder="请输入计量单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="规格型号" prop="specificationModel">
        <el-input
          v-model="queryParams.specificationModel"
          placeholder="请输入规格型号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
 </div>
        </el-col>
        <el-col :span="3">
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
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
          v-hasPermi="['storage:BasicToolInformation:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['storage:BasicToolInformation:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['storage:BasicToolInformation:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['storage:BasicToolInformation:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="BasicToolInformationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="刀具名称" align="center" prop="name" />
      <el-table-column label="刀具分类" align="center" prop="typeID" />
      <el-table-column label="刀具规格" align="center" prop="specificationsID" />
      <el-table-column label="计量单位id" align="center" prop="unitID" />
      <el-table-column label="备注信息" align="center" prop="notes" />
      <el-table-column label="类别名称" align="center" prop="typeName" />
      <el-table-column label="计量单位" align="center" prop="uint" />
      <el-table-column label="规格类型" align="center" prop="specificationsType" />
      <el-table-column label="规格型号" align="center" prop="specificationModel" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
        <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleView(scope.row)"
            v-hasPermi="['storage:BasicToolInformation:query']"
          >查看</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['storage:BasicToolInformation:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['storage:BasicToolInformation:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改BasicToolInformation对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="刀具编号" prop="id">
          <el-input v-model="form.id" placeholder="请输入刀具编号" />
        </el-form-item>
        <el-form-item label="刀具名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入刀具名称" />
        </el-form-item>
        <el-form-item label="刀具分类" prop="typeID">
          <el-input v-model="form.typeID" placeholder="请输入刀具分类" />
        </el-form-item>
        <el-form-item label="刀具规格" prop="specificationsID">
          <el-input v-model="form.specificationsID" placeholder="请输入刀具规格" />
        </el-form-item>
        <el-form-item label="计量单位id" prop="unitID">
          <el-input v-model="form.unitID" placeholder="请输入计量单位id" />
        </el-form-item>
        <el-form-item label="备注信息" prop="notes">
          <el-input v-model="form.notes" placeholder="请输入备注信息" />
        </el-form-item>
        <el-form-item label="类别名称" prop="typeName">
          <el-input v-model="form.typeName" placeholder="请输入类别名称" />
        </el-form-item>
        <el-form-item label="计量单位" prop="uint">
          <el-input v-model="form.uint" placeholder="请输入计量单位" />
        </el-form-item>
        <el-form-item label="规格型号" prop="specificationModel">
          <el-input v-model="form.specificationModel" placeholder="请输入规格型号" />
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
import { listBasicToolInformation, getBasicToolInformation, delBasicToolInformation, addBasicToolInformation, updateBasicToolInformation } from "@/api/storage/BasicToolInformation";

export default {
  name: "BasicToolInformation",
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
      // BasicToolInformation表格数据
      BasicToolInformationList: [],
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
        name: null,
        typeID: null,
        specificationsID: null,
        unitID: null,
        notes: null,
        typeName: null,
        uint: null,
        specificationsType: null,
        specificationModel: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [
          { required: true, message: "刀具编号不能为空", trigger: "blur" }
        ],
        name: [
          { required: true, message: "刀具名称不能为空", trigger: "blur" }
        ],
        typeID: [
          { required: true, message: "刀具分类不能为空", trigger: "blur" }
        ],
        specificationsID: [
          { required: true, message: "刀具规格不能为空", trigger: "blur" }
        ],
        unitID: [
          { required: true, message: "计量单位id不能为空", trigger: "blur" }
        ],
        uint: [
          { required: true, message: "计量单位不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询BasicToolInformation列表 */
    getList() {
      this.loading = true;
      listBasicToolInformation(this.queryParams).then(response => {
        this.BasicToolInformationList = response.rows;
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
        name: null,
        typeID: null,
        specificationsID: null,
        unitID: null,
        notes: null,
        typeName: null,
        uint: null,
        specificationsType: null,
        specificationModel: null
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    handleView(row) {
      this.view_open = true;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.open = true;
      this.title = "添加BasicToolInformation";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids
      getBasicToolInformation(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改BasicToolInformation";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (!this.isadd) {
            updateBasicToolInformation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBasicToolInformation(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除BasicToolInformation编号为"' + ids + '"的数据项？').then(function() {
        return delBasicToolInformation(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('storage/BasicToolInformation/export', {
        ...this.queryParams
      }, `BasicToolInformation_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
