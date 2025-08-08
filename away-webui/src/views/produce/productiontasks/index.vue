<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="生产任务单编号" prop="productionTasksFormID">
        <el-input
          v-model="queryParams.productionTasksFormID"
          placeholder="请输入生产任务单编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="生产任务序号" prop="serialNum">
        <el-input
          v-model="queryParams.serialNum"
          placeholder="请输入生产任务序号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="销售订单编号" prop="saleOrderID">
        <el-input
          v-model="queryParams.saleOrderID"
          placeholder="请输入销售订单编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="外协" prop="outsourced">
        <el-input
          v-model="queryParams.outsourced"
          placeholder="请输入外协"
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
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
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
          v-hasPermi="['produce:productiontasks:add']"
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
          v-hasPermi="['produce:productiontasks:edit']"
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
          v-hasPermi="['produce:productiontasks:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['produce:productiontasks:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="productiontasksList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="任务编号" align="center" prop="id" />
      <el-table-column label="生产任务单编号" align="center" prop="productionTasksFormID" />
      <el-table-column label="生产任务序号" align="center" prop="serialNum" />
      <el-table-column label="销售订单编号" align="center" prop="saleOrderID" />
      <el-table-column label="外协" align="center" prop="outsourced" />
      <el-table-column label="任务状态" align="center" prop="status" />
      <el-table-column label="备注" align="center" prop="notes" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['produce:productiontasks:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['produce:productiontasks:remove']"
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

    <!-- 添加或修改生产任务对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="生产任务单编号" prop="productionTasksFormID">
          <el-input v-model="form.productionTasksFormID" placeholder="请输入生产任务单编号" />
        </el-form-item>
        <el-form-item label="生产任务序号" prop="serialNum">
          <el-input v-model="form.serialNum" placeholder="请输入生产任务序号" />
        </el-form-item>
        <el-form-item label="销售订单编号" prop="saleOrderID">
          <el-input v-model="form.saleOrderID" placeholder="请输入销售订单编号" />
        </el-form-item>
        <el-form-item label="外协" prop="outsourced">
          <el-input v-model="form.outsourced" placeholder="请输入外协" />
        </el-form-item>
        <el-form-item label="备注" prop="notes">
          <el-input v-model="form.notes" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>J
  </div>
</template>

<script>
import { listProductiontasks, getProductiontasks, delProductiontasks, addProductiontasks, updateProductiontasks } from "@/api/produce/productiontasks";

export default {
  name: "Productiontasks",
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
      // 生产任务表格数据
      productiontasksList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        productionTasksFormID: null,
        serialNum: null,
        saleOrderID: null,
        outsourced: null,
        status: null,
        notes: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        productionTasksFormID: [
          { required: true, message: "生产任务单编号不能为空", trigger: "blur" }
        ],
        serialNum: [
          { required: true, message: "生产任务序号不能为空", trigger: "blur" }
        ],
        saleOrderID: [
          { required: true, message: "销售订单编号不能为空", trigger: "blur" }
        ],
        outsourced: [
          { required: true, message: "外协不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "任务状态不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询生产任务列表 */
    getList() {
      this.loading = true;
      listProductiontasks(this.queryParams).then(response => {
        this.productiontasksList = response.rows;
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
        productionTasksFormID: null,
        serialNum: null,
        saleOrderID: null,
        outsourced: null,
        status: "0",
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
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加生产任务";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getProductiontasks(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改生产任务";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateProductiontasks(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProductiontasks(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除生产任务编号为"' + ids + '"的数据项？').then(function() {
        return delProductiontasks(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('produce/productiontasks/export', {
        ...this.queryParams
      }, `productiontasks_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
