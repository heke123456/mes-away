<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
    <el-row :gutter="1">
            <el-col :span="21">
              <div style="overflow-x: auto;scrollbar-width: none; white-space: nowrap;">
      <el-form-item label="材料基本信息id" prop="materialID">
        <el-input
          v-model="queryParams.materialID"
          placeholder="请输入材料基本信息id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="材料名称" prop="materianame">
        <el-input
          v-model="queryParams.materianame"
          placeholder="请输入材料名称"
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
      <el-form-item label="规格型号" prop="specificationModel">
        <el-input
          v-model="queryParams.specificationModel"
          placeholder="请输入规格型号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="材料密度" prop="materialDensity">
        <el-input
          v-model="queryParams.materialDensity"
          placeholder="请输入材料密度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实体姓名" prop="customname">
        <el-input
          v-model="queryParams.customname"
          placeholder="请输入实体姓名"
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
          v-hasPermi="['storage:CsmtInvtDetls:add']"
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
          v-hasPermi="['storage:CsmtInvtDetls:edit']"
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
          v-hasPermi="['storage:CsmtInvtDetls:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['storage:CsmtInvtDetls:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="CsmtInvtDetlsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="销售订单编号" align="center" prop="saleorderID" />
      <el-table-column label="材料基本信息id" align="center" prop="materialID" />
      <el-table-column label="材料库存数量" align="center" prop="number" />
      <el-table-column label="材料库存重量" align="center" prop="weight" />
      <el-table-column label="材料名称" align="center" prop="materianame" />
      <el-table-column label="类别名称" align="center" prop="typeName" />
      <el-table-column label="规格类型" align="center" prop="specificationsType" />
      <el-table-column label="规格型号" align="center" prop="specificationModel" />
      <el-table-column label="材料密度" align="center" prop="materialDensity" />
      <el-table-column label="实体姓名" align="center" prop="customname" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
        <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleView(scope.row)"
            v-hasPermi="['storage:CsmtInvtDetls:query']"
          >查看</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['storage:CsmtInvtDetls:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['storage:CsmtInvtDetls:remove']"
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

    <!-- 添加或修改客供实时库存对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="材料库存id" prop="id">
          <el-input v-model="form.id" placeholder="请输入材料库存id" />
        </el-form-item>
        <el-form-item label="销售订单编号" prop="saleorderID">
          <el-input v-model="form.saleorderID" placeholder="请输入销售订单编号" />
        </el-form-item>
        <el-form-item label="材料基本信息id" prop="materialID">
          <el-input v-model="form.materialID" placeholder="请输入材料基本信息id" />
        </el-form-item>
        <el-form-item label="材料库存数量" prop="number">
          <el-input v-model="form.number" placeholder="请输入材料库存数量" />
        </el-form-item>
        <el-form-item label="材料库存重量" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入材料库存重量" />
        </el-form-item>
        <el-form-item label="材料名称" prop="materianame">
          <el-input v-model="form.materianame" placeholder="请输入材料名称" />
        </el-form-item>
        <el-form-item label="类别名称" prop="typeName">
          <el-input v-model="form.typeName" placeholder="请输入类别名称" />
        </el-form-item>
        <el-form-item label="规格型号" prop="specificationModel">
          <el-input v-model="form.specificationModel" placeholder="请输入规格型号" />
        </el-form-item>
        <el-form-item label="材料密度" prop="materialDensity">
          <el-input v-model="form.materialDensity" placeholder="请输入材料密度" />
        </el-form-item>
        <el-form-item label="备注信息" prop="notes">
          <el-input v-model="form.notes" placeholder="请输入备注信息" />
        </el-form-item>
        <el-form-item label="实体姓名" prop="customname">
          <el-input v-model="form.customname" placeholder="请输入实体姓名" />
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
import { listCsmtInvtDetls, getCsmtInvtDetls, delCsmtInvtDetls, addCsmtInvtDetls, updateCsmtInvtDetls } from "@/api/storage/CsmtInvtDetls";

export default {
  name: "CsmtInvtDetls",
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
      // 客供实时库存表格数据
      CsmtInvtDetlsList: [],
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
        materialID: null,
        materianame: null,
        typeName: null,
        specificationsType: null,
        specificationModel: null,
        materialDensity: null,
        customname: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [
          { required: true, message: "材料库存id不能为空", trigger: "blur" }
        ],
        saleorderID: [
          { required: true, message: "销售订单编号不能为空", trigger: "blur" }
        ],
        materialID: [
          { required: true, message: "材料基本信息id不能为空", trigger: "blur" }
        ],
        number: [
          { required: true, message: "材料库存数量不能为空", trigger: "blur" }
        ],
        weight: [
          { required: true, message: "材料库存重量不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询客供实时库存列表 */
    getList() {
      this.loading = true;
      listCsmtInvtDetls(this.queryParams).then(response => {
        this.CsmtInvtDetlsList = response.rows;
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
        saleorderID: null,
        materialID: null,
        number: null,
        weight: null,
        materianame: null,
        typeName: null,
        specificationsType: null,
        specificationModel: null,
        materialDensity: null,
        notes: null,
        customname: null
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
      this.title = "添加客供实时库存";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids
      getCsmtInvtDetls(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改客供实时库存";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (!this.isadd) {
            updateCsmtInvtDetls(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCsmtInvtDetls(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除客供实时库存编号为"' + ids + '"的数据项？').then(function() {
        return delCsmtInvtDetls(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('storage/CsmtInvtDetls/export', {
        ...this.queryParams
      }, `CsmtInvtDetls_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
