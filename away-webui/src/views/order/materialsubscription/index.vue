<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
    <el-row :gutter="1">
            <el-col :span="21">
              <div style="overflow-x: auto;scrollbar-width: none; white-space: nowrap;">
      <el-form-item label="申购单编号" prop="subscribeID">
        <el-input
          v-model="queryParams.subscribeID"
          placeholder="请输入申购单编号"
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
      <el-form-item label="材料信息编号" prop="materialID">
        <el-input
          v-model="queryParams.materialID"
          placeholder="请输入材料信息编号"
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
      <el-form-item label="申购数量" prop="subscriptionQuantity">
        <el-input
          v-model="queryParams.subscriptionQuantity"
          placeholder="请输入申购数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="需用日期" prop="requiredDate">
        <el-date-picker clearable
          v-model="queryParams.requiredDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择需用日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="备注" prop="note">
        <el-input
          v-model="queryParams.note"
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
          v-hasPermi="['order:materialsubscription:add']"
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
          v-hasPermi="['order:materialsubscription:edit']"
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
          v-hasPermi="['order:materialsubscription:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['order:materialsubscription:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="materialsubscriptionList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="申购材料编号" align="center" prop="materialSubscription" />
      <el-table-column label="申购单编号" align="center" prop="subscribeID" />
      <el-table-column label="任务编号" align="center" prop="productionTasksID" />
      <el-table-column label="材料信息编号" align="center" prop="materialID" />
      <el-table-column label="工艺编号" align="center" prop="processingTechnologyID" />
      <el-table-column label="申购数量" align="center" prop="subscriptionQuantity" />
      <el-table-column label="需用日期" align="center" prop="requiredDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.requiredDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="附样" align="center" prop="sampleURL" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.sampleURL" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="note" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
        <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleView(scope.row)"
            v-hasPermi="['order:materialsubscription:query']"
          >查看</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['order:materialsubscription:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['order:materialsubscription:remove']"
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

    <!-- 添加或修改申购材料对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="申购单编号" prop="subscribeID">
          <el-input v-model="form.subscribeID" placeholder="请输入申购单编号" />
        </el-form-item>
        <el-form-item label="任务编号" prop="productionTasksID">
          <el-input v-model="form.productionTasksID" placeholder="请输入任务编号" />
        </el-form-item>
        <el-form-item label="材料信息编号" prop="materialID">
          <el-input v-model="form.materialID" placeholder="请输入材料信息编号" />
        </el-form-item>
        <el-form-item label="工艺编号" prop="processingTechnologyID">
          <el-input v-model="form.processingTechnologyID" placeholder="请输入工艺编号" />
        </el-form-item>
        <el-form-item label="申购数量" prop="subscriptionQuantity">
          <el-input v-model="form.subscriptionQuantity" placeholder="请输入申购数量" />
        </el-form-item>
        <el-form-item label="需用日期" prop="requiredDate">
          <el-date-picker clearable
            v-model="form.requiredDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择需用日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="附样" prop="sampleURL">
          <image-upload v-model="form.sampleURL"/>
        </el-form-item>
        <el-form-item label="备注" prop="note">
          <el-input v-model="form.note" placeholder="请输入备注" />
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
import { listMaterialsubscription, getMaterialsubscription, delMaterialsubscription, addMaterialsubscription, updateMaterialsubscription } from "@/api/order/materialsubscription";

export default {
  name: "Materialsubscription",
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
      // 申购材料表格数据
      materialsubscriptionList: [],
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
        subscribeID: null,
        productionTasksID: null,
        materialID: null,
        processingTechnologyID: null,
        subscriptionQuantity: null,
        requiredDate: null,
        sampleURL: null,
        note: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        subscribeID: [
          { required: true, message: "申购单编号不能为空", trigger: "blur" }
        ],
        productionTasksID: [
          { required: true, message: "任务编号不能为空", trigger: "blur" }
        ],
        materialID: [
          { required: true, message: "材料信息编号不能为空", trigger: "blur" }
        ],
        processingTechnologyID: [
          { required: true, message: "工艺编号不能为空", trigger: "blur" }
        ],
        subscriptionQuantity: [
          { required: true, message: "申购数量不能为空", trigger: "blur" }
        ],
        requiredDate: [
          { required: true, message: "需用日期不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询申购材料列表 */
    getList() {
      this.loading = true;
      listMaterialsubscription(this.queryParams).then(response => {
        this.materialsubscriptionList = response.rows;
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
        materialSubscription: null,
        subscribeID: null,
        productionTasksID: null,
        materialID: null,
        processingTechnologyID: null,
        subscriptionQuantity: null,
        requiredDate: null,
        sampleURL: null,
        note: null
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
      this.ids = selection.map(item => item.materialSubscription)
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
      this.title = "添加申购材料";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const materialSubscription = row.materialSubscription || this.ids
      getMaterialsubscription(materialSubscription).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改申购材料";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (!this.isadd) {
            updateMaterialsubscription(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMaterialsubscription(this.form).then(response => {
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
      const materialSubscriptions = row.materialSubscription || this.ids;
      this.$modal.confirm('是否确认删除申购材料编号为"' + materialSubscriptions + '"的数据项？').then(function() {
        return delMaterialsubscription(materialSubscriptions);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('order/materialsubscription/export', {
        ...this.queryParams
      }, `materialsubscription_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
