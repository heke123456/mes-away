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
      <el-form-item label="质检名称" prop="nameOfQualityInspection">
        <el-input
          v-model="queryParams.nameOfQualityInspection"
          placeholder="请输入质检名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="质检类别" prop="qualityInspectionCategory">
        <el-select
          v-model="queryParams.qualityInspectionCategory"
          placeholder="请选择质检类别"
          clearable
          @keyup.enter.native="handleQuery"
        >
          <el-option
            v-for="item in dict.type.aw_qualityinspectioncategory_dict"
            :key="item.key"
            :label="item.label"
            :value="item.value"
          >
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="任务编号" prop="productionTasksID">
        <el-input
          v-model="queryParams.productionTasksID"
          placeholder="请输入任务编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工序编号" prop="processingprocessID">
        <el-input
          v-model="queryParams.processingprocessID"
          placeholder="请输入工序编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
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
          @keyup.enter.native="handleQuery"
        >
          <el-option
            v-for="item in dict.type.aw_quality_shippinginspection_status"
            :key="item.key"
            :label="item.label"
            :value="item.value"
          >
          </el-option>
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
          v-hasPermi="['quality:processinspection:add']"
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
          v-hasPermi="['quality:processinspection:edit']"
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
          v-hasPermi="['quality:processinspection:remove']"
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
          v-hasPermi="['quality:processinspection:export']"
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
      :data="processinspectionList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column
        label="质检名称"
        align="center"
        prop="nameOfQualityInspection"
      />

      <el-table-column
        label="质检类别"
        align="center"
        prop="qualityInspectionCategory"
      >
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.aw_qualityinspectioncategory_dict"
            :value="scope.row.qualityInspectionCategory"
          />
        </template>
      </el-table-column>

      <el-table-column
        label="任务编号"
        align="center"
        prop="productionTasksID"
      />
      <el-table-column
        label="工序编号"
        align="center"
        prop="processingprocessID"
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
      <el-table-column label="返修数量" align="center" prop="numberOfRepairs" />
      <el-table-column
        label="报废数量"
        align="center"
        prop="scrappedQuantity"
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
            v-hasPermi="['quality:processinspection:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['quality:processinspection:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['quality:processinspection:remove']"
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

    <!-- 添加或修改过程检验对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form
        ref="form"
        :model="form"
        :rules="rules"
        label-width="80px"
        :disabled="view_open"
      >
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="质检名称" prop="nameOfQualityInspection">
              <el-input
                v-model="form.nameOfQualityInspection"
                placeholder="请输入质检名称"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="质检类别" prop="qualityInspectionCategory">
              <el-select
                v-model="form.qualityInspectionCategory"
                placeholder="请选择质检类别"
                filterable
              >
                <el-option
                  v-for="item in qualityInspectionCategory_dict"
                  :key="item.key"
                  :label="item.value"
                  :value="item.key"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="任务单">
              <el-select
                v-model="productiontasklist"
                placeholder="请选择任务单"
                filterable
                @focus="getListProductiontasklist()"
              >
                <el-option
                  v-for="item in productiontasklist_list"
                  :key="item.id"
                  :label="item.referred"
                  :value="item.id"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="任务" prop="productionTasksID">
              <el-select
                v-model="form.productionTasksID"
                :disabled="productiontasklist == null ? true : false"
                placeholder="请选择任务"
                filterable
                @focus="getListProductiontasks()"
              >
                <el-option
                  v-for="item in productiontasks_list"
                  :key="item.id"
                  :label="item.id"
                  :value="item.id"
                  @click.native="setProcessingTechnologyID(item)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="订单编号">
              <el-input v-model="order.id" placeholder="订单编号" disabled />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="订单批次号">
              <el-input
                v-model="order.lotNumber"
                placeholder="请输入订单批次号"
                disabled
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="产品图号">
              <el-input
                v-model="product.id"
                placeholder="请输入产品图号"
                disabled
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="工序" prop="processingprocessID">
              <el-select
                v-model="form.processingprocessID"
                :disabled="processingTechnologyID == null ? true : false"
                placeholder="请选择工序"
                filterable
                @focus="getListProcessingprocess()"
              >
                <el-option
                  v-for="item in processingprocess_list"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="检测数量" prop="detectionQuantity">
              <el-input
                type="number"
                v-model="form.detectionQuantity"
                placeholder="请输入检测数量"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="合格数量" prop="qualifiedQuantity">
              <el-input
                type="number"
                v-model="form.qualifiedQuantity"
                placeholder="请输入合格数量"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="不合格数量" prop="unqualifiedQuantity">
              <el-input
                type="number"
                v-model="form.unqualifiedQuantity"
                placeholder="请输入不合格数量"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="返修数量" prop="numberOfRepairs">
              <el-input
                type="number"
                v-model="form.numberOfRepairs"
                placeholder="请输入返修数量"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="报废数量" prop="scrappedQuantity">
              <el-input
                type="number"
                v-model="form.scrappedQuantity"
                placeholder="请输入报废数量"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12"> </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="检测日期" prop="testDate">
              <el-date-picker
                clearable
                v-model="form.testDate"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择检测日期"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="检测结果" prop="testResult">
              <el-select
                v-model="form.testResult"
                placeholder="请选择检测结果"
                filterable
              >
                <el-option
                  v-for="item in testResult_option"
                  :key="item.key"
                  :label="item.value"
                  :value="item.key"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="检测人员" prop="testingPersonnel">
              <el-input
                v-model="form.testingPersonnel"
                placeholder="请输入检测人员"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="加工人员" prop="processingPersonnel">
              <el-input
                v-model="form.processingPersonnel"
                placeholder="请输入加工人员"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="24">
            <el-form-item label="备注" prop="note">
              <el-input
                type="textarea"
                v-model="form.note"
                placeholder="请输入备注"
              />
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer" v-if="!view_open">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import "@/assets/styles/away-element-ui-disabled.scss"; // away css

import {
  listProcessinspection,
  getProcessinspection,
  delProcessinspection,
  addProcessinspection,
  updateProcessinspection,
} from "@/api/quality/processinspection";
import { listProductiontasklist } from "@/api/produce/productiontasklist";
import {
  listProductiontasks,
  getProductiontasks,
} from "@/api/produce/productiontasks";
import { listProcessingprocess } from "@/api/produce/processingprocess";
import { getValue } from "@/utils/utils.js";

import { getSaleorder } from "@/api/order/saleorder";

import { getProduct } from "@/api/order/product";

export default {
  name: "Processinspection",
  dicts: [
    "aw_quality_shippinginspection_status",
    "aw_qualityinspectioncategory_dict",
  ],
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
      // 过程检验表格数据
      processinspectionList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否查看详情
      open_view: false,
      view_open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        nameOfQualityInspection: null,
        qualityInspectionCategory: null,
        productionTasksID: null,
        processingprocessID: null,
        detectionQuantity: null,
        qualifiedQuantity: null,
        unqualifiedQuantity: null,
        numberOfRepairs: null,
        scrappedQuantity: null,
        testDate: null,
        testResult: null,
        testingPersonnel: null,
        processingPersonnel: null,
        note: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        nameOfQualityInspection: [
          { required: true, message: "质检名称不能为空", trigger: "blur" },
        ],
        qualityInspectionCategory: [
          { required: true, message: "质检类别不能为空", trigger: "blur" },
        ],
        productionTasksID: [
          { required: true, message: "任务不能为空", trigger: "blur" },
        ],
        processingprocessID: [
          { required: true, message: "工序不能为空", trigger: "blur" },
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
        numberOfRepairs: [
          { required: true, message: "返修数量不能为空", trigger: "blur" },
        ],
        scrappedQuantity: [
          { required: true, message: "报废数量不能为空", trigger: "blur" },
        ],
        testDate: [
          { required: true, message: "检测日期不能为空", trigger: "blur" },
        ],
        testResult: [
          { required: true, message: "检测结果不能为空", trigger: "blur" },
        ],
        testingPersonnel: [
          { required: true, message: "检测人员不能为空", trigger: "blur" },
        ],
        processingPersonnel: [
          { required: true, message: "加工人员不能为空", trigger: "blur" },
        ],
      },
      // 任务单列表
      productiontasklist_list: [],
      // 当前创建检验选中任务单
      productiontasklist: null,
      // 任务列表
      productiontasks_list: [],
      // 工艺选中
      processingTechnologyID: null,
      // 工序列表
      processingprocess_list: [],
      // 质检类别
      qualityInspectionCategory_dict: [
        { key: "0", value: "首检" },
        { key: "1", value: "二检" },
        { key: "2", value: "尾检" },
      ],
      // 质检结构
      testResult_option: [
        { key: "0", value: "检验通过" },
        { key: "1", value: "检验不通过" },
        { key: "2", value: "检验完毕" },
      ],

      //订单对象

      order: {},
      product: {},
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询过程检验列表 */
    getList() {
      this.loading = true;
      listProcessinspection(this.queryParams).then((response) => {
        this.processinspectionList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询任务单列表 */
    async getListProductiontasklist() {
      this.loading = true;
      let total = (await listProductiontasklist())["total"];

      listProductiontasklist({ status: "1", pageSize: total }).then(
        (response) => {
          this.productiontasklist_list = response.rows;
          this.loading = false;
        }
      );
    },
    /** 查询任务列表 */
    async getListProductiontasks() {
      this.loading = true;
      let total = (await listProductiontasks())["total"];
      listProductiontasks({
        pageSize: total,
        status: "1",
        productionTasksFormID: String(this.productiontasklist),
      }).then((response) => {
        this.productiontasks_list = response.rows;
        this.loading = false;
      });
    },
    /** 查询工序列表 */
    async getListProcessingprocess() {
      this.loading = true;
      let total = (await listProcessingprocess())["total"];
      listProcessingprocess({
        pageSize: total,
        processingTechnologyID: String(this.processingTechnologyID),
      }).then((response) => {
        this.processingprocess_list = response.rows;
        this.loading = false;
      });
    },
    /** 选中工艺 */
    setProcessingTechnologyID(item) {
      let value = item.processingTechnologyID;
      this.processingTechnologyID = value;

      //根据任务拿到订单
      console.log(item);
      getSaleorder(item.saleOrderID).then((response) => {
        this.order = response.data;
        console.log(this.order.id);
        getProduct(this.order.productID).then((response) => {
          this.product = response.data;
          console.log(this.product.id);
        });
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
        nameOfQualityInspection: null,
        qualityInspectionCategory: null,
        productionTasksID: null,
        processingprocessID: null,
        detectionQuantity: null,
        qualifiedQuantity: null,
        unqualifiedQuantity: null,
        numberOfRepairs: null,
        scrappedQuantity: null,
        testDate: null,
        testResult: null,
        testingPersonnel: null,
        processingPersonnel: null,
        note: null,
      };
      // 任务单子列表
      this.productiontasks_list = [];
      // 任务单列表
      this.productiontasklist_list = [];
      // 当前创建检验选中任务单
      this.productiontasklist = null;
      // 任务列表
      this.productiontasks_list = [];
      // 当前创建检验选中任务
      this.productiontask = null;
      // 当前创建检验选中工序
      this.processingTechnologyID = null;
      //当前订单
      this.order = {};
      //当前产品
      this.product = {};
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
    /** 详情按钮操作 */
    handleView(row) {
      this.reset();
      const id = row.id || this.ids;
      getProcessinspection(id).then((response) => {
        this.form = response.data;
        this.open = true;
        getProductiontasks(row.productionTasksID).then(async (response) => {
          let productionTasksFormID = response.data.productionTasksFormID;

          //查出订单和图号

          getSaleorder(response.data.saleOrderID).then((response) => {
            this.order = response.data;

            console.log(this.order.id);
            getProduct(this.order.productID).then((response) => {
              this.product = response.data;
              console.log(this.product.id);
            });
          });

          let total = (await listProductiontasklist())["total"];

          listProductiontasklist({ pageSize: total }).then((response) => {
            this.productiontasklist_list = response.rows;
            this.productiontasklist = productionTasksFormID;
          });
        });
        this.view_open = true;
        this.title = "查看过程检验";
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.view_open = false;
      this.title = "添加过程检验";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getProcessinspection(id).then((response) => {
        this.form = response.data;
        this.open = true;
        getProductiontasks(row.productionTasksID).then(async (response) => {
          let productionTasksFormID = response.data.productionTasksFormID;

          //查出订单和图号

          getSaleorder(response.data.saleOrderID).then((response) => {
            this.order = response.data;

            console.log(this.order.id);
            getProduct(this.order.productID).then((response) => {
              this.product = response.data;
              console.log(this.product.id);
            });
          });

          let total = (await listProductiontasklist())["total"];

          listProductiontasklist({ pageSize: total }).then((response) => {
            this.productiontasklist_list = response.rows;
            this.productiontasklist = productionTasksFormID;
          });
        });
        this.view_open = false;
        this.title = "查看过程检验";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        console.log(this.form);
        if (valid) {
          if (this.form.id != null) {
            updateProcessinspection(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProcessinspection(this.form).then((response) => {
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
        .confirm('是否确认删除过程检验编号为"' + ids + '"的数据项？')
        .then(function () {
          return delProcessinspection(ids);
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
        "quality/processinspection/export",
        {
          ...this.queryParams,
        },
        `processinspection_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
