<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
    <el-row :gutter="1">
            <el-col :span="21">
              <div style="overflow-x: auto;scrollbar-width: none; white-space: nowrap;">
      <el-form-item label="入库单编号" prop="warehouseEntryID">
        <el-input
          v-model="queryParams.warehouseEntryID"
          placeholder="请输入入库单编号"
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
      <el-form-item label="刀具基本信息" prop="toolInformationID">
        <el-input
          v-model="queryParams.toolInformationID"
          placeholder="请输入刀具基本信息"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入库数量" prop="receiptQuantity">
        <el-input
          v-model="queryParams.receiptQuantity"
          placeholder="请输入入库数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['storage:toolStorage:add']"
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
          v-hasPermi="['storage:toolStorage:edit']"
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
          v-hasPermi="['storage:toolStorage:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['storage:toolStorage:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="toolStorageList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="刀具入库id" align="center" prop="id" />
      <el-table-column label="入库单编号" align="center" prop="warehouseEntryID" />
      <el-table-column label="发票信息编号" align="center" prop="receiptInvoiceID" />
      <el-table-column label="刀具基本信息" align="center" prop="toolInformationID" />
      <el-table-column label="入库数量" align="center" prop="receiptQuantity" />
      <el-table-column label="备注" align="center" prop="notes" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
        <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleView(scope.row)"
            v-hasPermi="['storage:toolStorage:query']"
          >查看</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['storage:toolStorage:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['storage:toolStorage:remove']"
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

    <!-- 添加或修改刀具入库对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="入库单编号" prop="warehouseEntryID">
          <el-input v-model="form.warehouseEntryID" placeholder="请输入入库单编号" />
        </el-form-item>
        <el-form-item label="发票信息编号" prop="receiptInvoiceID">
          <el-input v-model="form.receiptInvoiceID" placeholder="请输入发票信息编号" />
        </el-form-item>
        <el-form-item label="刀具基本信息" prop="toolInformationID">
          <el-input v-model="form.toolInformationID" placeholder="请输入刀具基本信息" />
        </el-form-item>
        <el-form-item label="入库数量" prop="receiptQuantity">
          <el-input v-model="form.receiptQuantity" placeholder="请输入入库数量" />
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
import { listToolStorage, getToolStorage, delToolStorage, addToolStorage, updateToolStorage } from "@/api/storage/toolStorage";

export default {
  name: "ToolStorage",
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
      // 刀具入库表格数据
      toolStorageList: [],
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
        receiptInvoiceID: null,
        toolInformationID: null,
        receiptQuantity: null,
        notes: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [
          { required: true, message: "刀具入库id不能为空", trigger: "blur" }
        ],
        warehouseEntryID: [
          { required: true, message: "入库单编号不能为空", trigger: "blur" }
        ],
        receiptInvoiceID: [
          { required: true, message: "发票信息编号不能为空", trigger: "blur" }
        ],
        toolInformationID: [
          { required: true, message: "刀具基本信息不能为空", trigger: "blur" }
        ],
        receiptQuantity: [
          { required: true, message: "入库数量不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询刀具入库列表 */
    getList() {
      this.loading = true;
      listToolStorage(this.queryParams).then(response => {
        this.toolStorageList = response.rows;
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
        warehouseEntryID: null,
        receiptInvoiceID: null,
        toolInformationID: null,
        receiptQuantity: null,
        notes: null
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
      this.title = "添加刀具入库";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids
      getToolStorage(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改刀具入库";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (!this.isadd) {
            updateToolStorage(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addToolStorage(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除刀具入库编号为"' + ids + '"的数据项？').then(function() {
        return delToolStorage(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('storage/toolStorage/export', {
        ...this.queryParams
      }, `toolStorage_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
