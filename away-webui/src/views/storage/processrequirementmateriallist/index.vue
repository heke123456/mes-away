<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
    <el-row :gutter="1">
            <el-col :span="21">
              <div style="overflow-x: auto;scrollbar-width: none; white-space: nowrap;">
      <el-form-item label="材料基础信息编号" prop="materialID">
        <el-input
          v-model="queryParams.materialID"
          placeholder="请输入材料基础信息编号"
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
      <el-form-item label="下料尺寸" prop="cuttingSize">
        <el-input
          v-model="queryParams.cuttingSize"
          placeholder="请输入下料尺寸"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="可制件数" prop="numberProducibleParts">
        <el-input
          v-model="queryParams.numberProducibleParts"
          placeholder="请输入可制件数"
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
          v-hasPermi="['storage:processrequirementmateriallist:add']"
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
          v-hasPermi="['storage:processrequirementmateriallist:edit']"
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
          v-hasPermi="['storage:processrequirementmateriallist:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['storage:processrequirementmateriallist:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="processrequirementmateriallistList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="材料基础信息编号" align="center" prop="materialID" />
      <el-table-column label="工艺编号" align="center" prop="processingTechnologyID" />
      <el-table-column label="下料尺寸" align="center" prop="cuttingSize" />
      <el-table-column label="可制件数" align="center" prop="numberProducibleParts" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
        <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleView(scope.row)"
            v-hasPermi="['storage:processrequirementmateriallist:query']"
          >查看</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['storage:processrequirementmateriallist:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['storage:processrequirementmateriallist:remove']"
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

    <!-- 添加或修改工艺需求材料对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="材料基础信息编号" prop="materialID">
          <el-input v-model="form.materialID" placeholder="请输入材料基础信息编号" />
        </el-form-item>
        <el-form-item label="工艺编号" prop="processingTechnologyID">
          <el-input v-model="form.processingTechnologyID" placeholder="请输入工艺编号" />
        </el-form-item>
        <el-form-item label="下料尺寸" prop="cuttingSize">
          <el-input v-model="form.cuttingSize" placeholder="请输入下料尺寸" />
        </el-form-item>
        <el-form-item label="可制件数" prop="numberProducibleParts">
          <el-input v-model="form.numberProducibleParts" placeholder="请输入可制件数" />
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
import { listProcessrequirementmateriallist, getProcessrequirementmateriallist, delProcessrequirementmateriallist, addProcessrequirementmateriallist, updateProcessrequirementmateriallist } from "@/api/storage/processrequirementmateriallist";

export default {
  name: "Processrequirementmateriallist",
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
      // 工艺需求材料表格数据
      processrequirementmateriallistList: [],
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
        processingTechnologyID: null,
        cuttingSize: null,
        numberProducibleParts: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        materialID: [
          { required: true, message: "材料基础信息编号不能为空", trigger: "blur" }
        ],
        processingTechnologyID: [
          { required: true, message: "工艺编号不能为空", trigger: "blur" }
        ],
        cuttingSize: [
          { required: true, message: "下料尺寸不能为空", trigger: "blur" }
        ],
        numberProducibleParts: [
          { required: true, message: "可制件数不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询工艺需求材料列表 */
    getList() {
      this.loading = true;
      listProcessrequirementmateriallist(this.queryParams).then(response => {
        this.processrequirementmateriallistList = response.rows;
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
        materialID: null,
        processingTechnologyID: null,
        cuttingSize: null,
        numberProducibleParts: null
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
      this.title = "添加工艺需求材料";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids
      getProcessrequirementmateriallist(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改工艺需求材料";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (!this.isadd) {
            updateProcessrequirementmateriallist(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProcessrequirementmateriallist(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除工艺需求材料编号为"' + ids + '"的数据项？').then(function() {
        return delProcessrequirementmateriallist(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('storage/processrequirementmateriallist/export', {
        ...this.queryParams
      }, `processrequirementmateriallist_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
