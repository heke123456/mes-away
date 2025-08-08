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
            <el-form-item label="检测日期" prop="testDate">
              <el-date-picker
                clearable
                v-model="queryParams.testDate"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择检测日期"
              >
              </el-date-picker>
            </el-form-item>
            <el-form-item label="检测结果" prop="testResult">
              <el-select
                v-model="queryParams.testResult"
                placeholder="请选择检测结果"
                clearable
              >
                <el-option
                  v-for="dict in dict.type.aw_quality_shippinginspection_status"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                />
              </el-select>
            </el-form-item>
            <el-form-item label="检测人员" prop="testingPersonnel">
              <el-input
                v-model="queryParams.testingPersonnel"
                placeholder="请输入检测人员"
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
          v-hasPermi="['quality:shippinginspection:add']"
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
          v-hasPermi="['quality:shippinginspection:edit']"
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
          v-hasPermi="['quality:shippinginspection:remove']"
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
          v-hasPermi="['quality:shippinginspection:export']"
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
      :data="shippinginspectionList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column
        label="出货数量"
        align="center"
        prop="shipmentQuantity"
      />
      <el-table-column
        label="检测数量"
        align="center"
        prop="detectionQuantity"
      />
      <el-table-column
        label="合格数量"
        align="center"
        prop="qualifiedQuantity"
      />
      <el-table-column
        label="不合格数量"
        align="center"
        prop="unqualifiedQuantity"
      />
      <el-table-column
        label="检测日期"
        align="center"
        prop="testDate"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.testDate, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="检测结果" align="center" prop="testResult">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.aw_quality_shippinginspection_status"
            :value="scope.row.testResult"
          />
        </template>
      </el-table-column>
      <el-table-column
        label="检测人员"
        align="center"
        prop="testingPersonnel"
      />
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
            v-hasPermi="['quality:shippinginspection:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['quality:shippinginspection:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['quality:shippinginspection:remove']"
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

    <!-- 添加或修改成品出货检验对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form
        ref="form"
        :model="form"
        :disabled="view_open"
        :rules="rules"
        label-width="120px"
      >
        <el-row :gutter="12"
          ><el-col :span="12"
            ><el-form-item label="出货检验编号" prop="id">
              <el-input
                v-model="form.id"
                placeholder="请输入出货检验编号"
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="检测人员" prop="testingPersonnel">
              <el-input
                v-model="form.testingPersonnel"
                placeholder="请输入检测人员"
              /> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="产品图号" prop="productID">
              <el-select
                filterable
                v-model="form.productID"
                placeholder="请选择产品图号"
                @focus="getListproduct()"
              >
                <el-option
                  v-for="(item, index) in productlist"
                  :key="index"
                  :label="item.name"
                  :value="item.id"
                >
                </el-option>
              </el-select> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="客户编号" prop="contractID">
              <el-select
                filterable
                v-model="form.contractID"
                placeholder="请选择客户编号"
                @focus="getListcustom()"
              >
                <el-option
                  v-for="(item, index) in customlist"
                  :key="index"
                  :label="item.name"
                  :value="item.id"
                >
                </el-option>
              </el-select> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="出货数量" prop="shipmentQuantity">
              <el-input
                v-model="form.shipmentQuantity"
                placeholder="请输入出货数量"
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="检测数量" prop="detectionQuantity">
              <el-input
                v-model="form.detectionQuantity"
                placeholder="请输入检测数量"
              /> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="合格数量" prop="qualifiedQuantity">
              <el-input
                v-model="form.qualifiedQuantity"
                placeholder="请输入合格数量"
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="不合格数量" prop="unqualifiedQuantity">
              <el-input
                v-model="form.unqualifiedQuantity"
                placeholder="请输入不合格数量"
              /> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="检测日期" prop="testDate">
              <el-date-picker
                clearable
                v-model="form.testDate"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择检测日期"
              >
              </el-date-picker> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="检测结果" prop="testResult">
              <el-select v-model="form.testResult" placeholder="请选择检测结果">
                <el-option
                  v-for="dict in dict.type.aw_quality_shippinginspection_status"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="24">
            <el-form-item label="备注" prop="notes">
              <el-input
                v-model="form.notes"
                placeholder="请输入备注"
              /> </el-form-item></el-col
        ></el-row>
      </el-form>
      <div slot="footer" v-if="!view_open" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listShippinginspection,
  getShippinginspection,
  delShippinginspection,
  addShippinginspection,
  updateShippinginspection,
} from "@/api/quality/shippinginspection";
import { listProduct, getProduct } from "@/api/order/product.js";
import { listCustom, getCustom } from "@/api/comprehensive/custom.js";
import "@/assets/styles/away-element-ui-disabled.scss"; // away css

export default {
  name: "Shippinginspection",
  dicts: ["aw_quality_shippinginspection_status"],
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
      // 成品出货检验表格数据
      shippinginspectionList: [],
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
        testDate: null,
        testResult: null,
        testingPersonnel: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [
          { required: true, message: "出货检验编号不能为空", trigger: "blur" },
        ],
        productID: [
          { required: true, message: "产品图号不能为空", trigger: "blur" },
        ],
        contractID: [
          { required: true, message: "客户编号不能为空", trigger: "blur" },
        ],
        shipmentQuantity: [
          { required: true, message: "出货数量不能为空", trigger: "blur" },
        ],
        detectionQuantity: [
          { required: true, message: "检测数量不能为空", trigger: "blur" },
        ],
        qualifiedQuantity: [
          { required: true, message: "合格数量不能为空", trigger: "blur" },
        ],
        unqualifiedQuantity: [
          { required: true, message: "不合格数量不能为空", trigger: "blur" },
        ],
        testDate: [
          { required: true, message: "检测日期不能为空", trigger: "blur" },
        ],
        testResult: [
          { required: true, message: "检测结果不能为空", trigger: "change" },
        ],
        testingPersonnel: [
          { required: true, message: "检测人员不能为空", trigger: "blur" },
        ],
      },
      // 产品列表
      productlist: [],
      // 客户信息列表
      customlist: [],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询成品出货检验列表 */
    getList() {
      this.loading = true;
      listShippinginspection(this.queryParams).then((response) => {
        this.shippinginspectionList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询产品信息 */
    async getListproduct() {
      this.loading = true;
      let total = (await listProduct())["total"];
      listProduct({ pageSize: total }).then((response) => {
        this.productlist = response.rows;
        this.loading = false;
      });
    },
    /** 查询客户信息 */
    async getListcustom() {
      this.loading = true;
      let total = (await listProduct())["total"];
      listCustom({ pageSize: total }).then((response) => {
        this.customlist = response.rows;
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
        productID: null,
        contractID: null,
        shipmentQuantity: null,
        detectionQuantity: null,
        qualifiedQuantity: null,
        unqualifiedQuantity: null,
        testDate: null,
        testResult: null,
        testingPersonnel: null,
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
    handleView(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getShippinginspection(id).then((response) => {
        this.form = response.data;
        this.view_open = true;
        this.open = true;
        this.title = "查看出货检验";
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.view_open = false;
      this.open = true;
      this.title = "添加出货检验";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getShippinginspection(id).then((response) => {
        this.form = response.data;
        this.view_open = false;
        this.open = true;
        this.title = "修改出货检验";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateShippinginspection(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addShippinginspection(this.form).then((response) => {
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
        .confirm('是否确认删除成品出货检验编号为"' + ids + '"的数据项？')
        .then(function () {
          return delShippinginspection(ids);
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
        "quality/shippinginspection/export",
        {
          ...this.queryParams,
        },
        `shippinginspection_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
