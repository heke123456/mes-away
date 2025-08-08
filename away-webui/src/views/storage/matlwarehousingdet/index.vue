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
      <el-form-item label="材料名称" prop="name">
        <el-input
          v-model="queryParams.name"
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
      <el-form-item label="规格类型" prop="specificationsType">
        <el-input
          v-model="queryParams.specificationsType"
          placeholder="请输入规格类型"
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
      <el-col :span="1.5" v-if="upper_status == '0'">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['storage:matlwarehousingdet:add']"
          >新增</el-button
        >
      </el-col>
      <el-col :span="1.5" v-if="upper_status == '0'">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['storage:matlwarehousingdet:edit']"
          >修改</el-button
        >
      </el-col>
      <el-col :span="1.5" v-if="upper_status == '0'">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['storage:matlwarehousingdet:remove']"
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
          v-hasPermi="['storage:matlwarehousingdet:export']"
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
      :data="matlwarehousingdetList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        label="入库单编号"
        align="center"
        prop="warehouseEntryID"
      />
      <el-table-column
        label="申购材料编号"
        align="center"
        prop="materialSubscription"
      />
      <el-table-column label="材料信息编号" align="center" prop="materialID" />
      <el-table-column label="材料名称" align="center" prop="name" />
      <el-table-column
        label="规格型号"
        align="center"
        prop="specificationModel"
      />
      <el-table-column
        label="发票信息编号"
        align="center"
        prop="receiptInvoiceID"
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
            v-hasPermi="['storage:matlwarehousingdet:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-if="upper_status == '0'"
            v-hasPermi="['storage:matlwarehousingdet:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-if="upper_status == '0'"
            v-hasPermi="['storage:matlwarehousingdet:remove']"
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

    <!-- 添加或修改材料入库详细对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form
        ref="matlwarehousingdet"
        :model="matlwarehousingdet"
        :rules="rules"
        label-width="80px"
        :disabled="view_open"
      >
        <!-- 入库信息 -->
        <el-row :gutter="12"
          ><el-col :span="12"
            ><el-form-item label="入库单编号" prop="warehouseEntryID">
              <el-input
                disabled
                v-model="matlwarehousingdet.warehouseEntryID"
                placeholder="请输入入库单编号"
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="入库数量" prop="receiptQuantity">
              <el-input
                v-model="matlwarehousingdet.receiptQuantity"
                placeholder="请输入入库数量"
              /> </el-form-item></el-col
        ></el-row>
        <!-- 申购信息 -->
        <el-row :gutter="12"
          ><el-col :span="12"
            ><el-form-item label="申购单">
              <el-select
                filterable
                v-model="purchaserequisition.subscribeID"
                placeholder="请选择申购单"
                clearable
                @focus="getListPurchaserequisition()"
              >
                <el-option
                  v-for="(item, index) in purchaserequisitionlist"
                  :key="index"
                  :label="item.subscribeID"
                  :value="item.subscribeID"
                  @click.native="setPurchaserequisition(item.subscribeID)"
                >
                </el-option>
              </el-select> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="申购材料编号" prop="materialSubscription">
              <el-select
                filterable
                :disabled="purchaserequisition.subscribeID == null"
                v-model="matlwarehousingdet.materialSubscription"
                placeholder="请选择申购材料"
                @focus="
                  getListDetailmaterialsubscription(
                    purchaserequisition.subscribeID
                  )
                "
              >
                <el-option
                  v-for="(item, index) in detailmaterialsubscriptionlist"
                  :key="index"
                  :label="item.materialID"
                  :value="item.materialSubscription"
                  @click.native="
                    setDetailmaterialsubscription(item.materialSubscription)
                  "
                >
                </el-option>
              </el-select> </el-form-item></el-col
        ></el-row>
        <!-- 材料信息 -->
        <el-row :gutter="12"
          ><el-col :span="12"
            ><el-form-item label="材料信息编号" prop="materialID">
              <el-select
                filterable
                :disabled="purchaserequisition.subscribeID != null"
                v-model="matlwarehousingdet.materialID"
                placeholder="请选择材料信息"
                @focus="getListBasicinformationofmaterials()"
              >
                <el-option
                  v-for="(item, index) in basicinformationofmaterialslist"
                  :key="index"
                  :label="item.name"
                  :value="item.id"
                  @click.native="setBasicinformationofmaterials(item.id)"
                >
                </el-option>
              </el-select> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="材料名称" prop="name">
              <el-input
                disabled
                v-model="matlwarehousingdet.name"
                placeholder="请输入材料名称"
              /> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="类别名称" prop="typeName">
              <el-input
                disabled
                v-model="matlwarehousingdet.typeName"
                placeholder="请输入类别名称"
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="规格类型" prop="specificationsType">
              <el-input
                disabled
                v-model="matlwarehousingdet.specificationsType"
                placeholder="请输入规格类型"
              /> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="规格型号" prop="specificationModel">
              <el-input
                disabled
                v-model="matlwarehousingdet.specificationModel"
                placeholder="请输入规格型号"
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="材料密度" prop="materialDensity">
              <el-input
                disabled
                v-model="matlwarehousingdet.materialDensity"
                placeholder="请输入材料密度"
              /> </el-form-item></el-col
        ></el-row>
        <!-- 发票信息 -->
        <el-row :gutter="12"
          ><el-col :span="12"
            ><el-form-item label="发票信息编号" prop="receiptInvoiceID">
              <el-select
                filterable
                v-model="matlwarehousingdet.receiptInvoiceID"
                placeholder="请选择发票信息"
                @focus="getListReceiptinvoice()"
              >
                <el-option
                  v-for="(item, index) in receiptinvoicelist"
                  :key="index"
                  :label="item.receiptInvoiceID"
                  :value="item.receiptInvoiceID"
                  @click.native="setReceiptinvoice(item.receiptInvoiceID)"
                >
                </el-option>
              </el-select> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="发票类型" prop="invoiceType">
              <el-input
                disabled
                v-model="matlwarehousingdet.invoiceType"
                placeholder="请输入发票类型"
              /> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="发票税率" prop="invoiceTaxRate">
              <el-input
                disabled
                v-model="matlwarehousingdet.invoiceTaxRate"
                placeholder="请输入发票税率"
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item
              label="不含税采购单价"
              prop="purchaseUnitPriceExcludingTax"
            >
              <el-input
                disabled
                v-model="matlwarehousingdet.purchaseUnitPriceExcludingTax"
                placeholder="请输入不含税采购单价"
              /> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item
              label="含税采购单价"
              prop="purchaseUnitPriceIncludingTax"
            >
              <el-input
                disabled
                v-model="matlwarehousingdet.purchaseUnitPriceIncludingTax"
                placeholder="请输入含税采购单价"
              /> </el-form-item
          ></el-col>

          <el-col :span="12">
            <el-form-item label="材料价格" prop="specificationsType">
              <el-input
                disabled
                v-model="matlwarehousingdet.materialPrice"
                placeholder="请输入材料价格"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 其他信息 -->
        <el-row :gutter="12"
          ><el-form-item label="附样" prop="sampleURL">
            <el-upload
              ref="upload"
              :file-list="fileList"
              action="String"
              :http-request="fileUpdate"
              :auto-upload="false"
              list-type="picture"
            >
              <el-button size="small" type="primary">点击上传</el-button>
              <div slot="tip" class="el-upload__tip">
                只能上传jpg/png文件，且不超过500kb
              </div>
            </el-upload>
          </el-form-item></el-row
        >
        <el-row :gutter="12"
          ><el-col :span="24"
            ><el-form-item label="备注" prop="notes">
              <el-input
                v-model="matlwarehousingdet.notes"
                placeholder="请输入备注"
              /> </el-form-item></el-col
        ></el-row>
      </el-form>
      <div v-if="!view_open" slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <el-dialog
      :title="'入库单编号:' + view_form.warehouseEntryID"
      :visible.sync="view_open"
      width="800px"
      append-to-body
    >
      <el-descriptions :column="2" border>
        <el-descriptions-item label="入库单编号">{{
          view_form.warehouseEntryID
        }}</el-descriptions-item>
        <el-descriptions-item label="入库数量">{{
          view_form.receiptQuantity
        }}</el-descriptions-item>
        <el-descriptions-item label="订单编号">{{
          view_form.warehouseEntryID
        }}</el-descriptions-item>
        <el-descriptions-item label="申购单">{{
          purchaserequisition.subscribeID
        }}</el-descriptions-item>

        <el-descriptions-item label="申购材料编号">{{
          view_form.materialSubscription
        }}</el-descriptions-item>

        <el-descriptions-item label="材料编号">{{
          view_form.materialID
        }}</el-descriptions-item>
        <el-descriptions-item label="材料名称">{{
          view_form.name
        }}</el-descriptions-item>

        <el-descriptions-item label="类别名称">{{
          view_form.typeName
        }}</el-descriptions-item>

        <el-descriptions-item label="规格类型">{{
          view_form.specificationsType
        }}</el-descriptions-item>
        <el-descriptions-item label="材料密度">{{
          view_form.materialDensity
        }}</el-descriptions-item>
        <el-descriptions-item label="材料价格">{{
          view_form.materialPrice
        }}</el-descriptions-item>

        <el-descriptions-item label="规格型号">{{
          view_form.specificationModel
        }}</el-descriptions-item>

        <el-descriptions-item label="发票信息">{{
          view_form.receiptInvoiceID
        }}</el-descriptions-item>

        <el-descriptions-item label="发票类型">{{
          view_form.invoiceType
        }}</el-descriptions-item>

        <el-descriptions-item label="发票税率">{{
          view_form.invoiceTaxRate
        }}</el-descriptions-item>

        <el-descriptions-item label="不含税采购单价">{{
          view_form.purchaseUnitPriceExcludingTax
        }}</el-descriptions-item>

        <el-descriptions-item label="含税采购单价">{{
          view_form.purchaseUnitPriceIncludingTax
        }}</el-descriptions-item>

        <el-descriptions-item label="备注">{{
          view_form.warehouseEntryID
        }}</el-descriptions-item>
        <el-descriptions-item label="产品图纸附件" :span="2">
          <filedown :files="view_form.files" />
        </el-descriptions-item>
      </el-descriptions>
    </el-dialog>
  </div>
</template>

<script>
import {
  listMatlwarehousingdet,
  getMatlwarehousingdet,
  delMatlwarehousingdet,
  addMatlwarehousingdet,
  updateMatlwarehousingdet,
} from "@/api/storage/matlwarehousingdet";
import {
  listPurchaserequisition,
  getPurchaserequisition,
} from "@/api/order/purchaserequisition.js";
import {
  listDetailmaterialsubscription,
  getDetailmaterialsubscription,
} from "@/api/order/detailmaterialsubscription.js";
import {
  listBasicinformationofmaterials,
  getBasicinformationofmaterials,
} from "@/api/storage/basicinformationofmaterials.js";
import {
  listReceiptinvoice,
  getReceiptinvoice,
} from "@/api/finance/receiptinvoice.js";

import { setIntersectionObj } from "@/utils/utils.js";
import "@/assets/styles/away-element-ui-disabled.scss"; // away css

import { fileDownload, fileUpdate } from "@/api/file/file";

import Filedown from "../../../components/FileDown/filedown.vue";
export default {
  name: "Matlwarehousingdet",
  components: { filedown: Filedown },

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
      // 材料入库详细表格数据
      matlwarehousingdetList: [],
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
        typeName: null,
        specificationsType: null,
        specificationModel: null,
        materialDensity: null,
      },
      // 表单参数
      form: {},
      // 文件列表
      fileList: [],
      // 订单详细查看
      view_form: [],

      // 表单校验
      rules: {
        id: [{ required: true, message: "id不能为空", trigger: "blur" }],
        warehouseEntryID: [
          { required: true, message: "入库单编号不能为空", trigger: "blur" },
        ],
        materialID: [
          { required: true, message: "材料信息编号不能为空", trigger: "blur" },
        ],
        name: [
          { required: true, message: "材料名称不能为空", trigger: "blur" },
        ],
        materialDensity: [
          { required: true, message: "材料密度不能为空", trigger: "blur" },
        ],
        receiptInvoiceID: [
          { required: true, message: "发票信息编号不能为空", trigger: "blur" },
        ],
        purchaseUnitPriceExcludingTax: [
          {
            required: true,
            message: "不含税采购单价不能为空",
            trigger: "blur",
          },
        ],
        receiptQuantity: [
          { required: true, message: "入库数量不能为空", trigger: "blur" },
        ],
      },
      // 当前入库单
      warehouseEntryID: "",
      // 材料入库详细
      matlwarehousingdet: {},
      // 父单状态
      upper_status: null,
      // 申购单列表
      purchaserequisitionlist: [],
      // 选中申购单
      purchaserequisition: {},
      // 申购材料列表
      detailmaterialsubscriptionlist: [],
      // 选中申购材料
      detailmaterialsubscription: {},
      // 材料信息列表
      basicinformationofmaterialslist: [],
      // 选中材料信息
      basicinformationofmaterials: {},
      // 发票信息列表
      receiptinvoicelist: [],
      // 选中发票信息
      receiptinvoice: {},
    };
  },
  created() {
    this.getExist();
  },
  methods: {
    /** 文件上传 */
    async fileUpdate() {
      let file_list = this.$refs.upload.uploadFiles;
      if (file_list.length > 0) {
        let num = 0;
        let formData = new FormData();
        for (num in file_list) {
          formData.append("files", file_list[num].raw);
        }
        let response = await fileUpdate(formData);
        this.form.sampleURL = response;
      }
    },
    /** 文件下载 */
    async fileDown(file_name) {
      let tmp = await fileDownload(file_name);
      this.view_form.files.push(tmp);
    },

    getExist() {
      this.warehouseEntryID = this.$route.query.id;
      this.queryParams.warehouseEntryID = this.warehouseEntryID;
      this.upper_status = this.$route.query.status;
      this.getList();
    },
    /** 查询材料入库详细列表 */
    getList() {
      this.loading = true;
      listMatlwarehousingdet(this.queryParams).then((response) => {
        this.matlwarehousingdetList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询申购单列表 */
    async getListPurchaserequisition() {
      this.loading = true;
      let total = (await listPurchaserequisition())["total"];
      listPurchaserequisition({ pageSize: total }).then((response) => {
        this.purchaserequisitionlist = response.rows;
        this.loading = false;
      });
    },
    /** 选中选中申购单 */
    setPurchaserequisition(id) {
      this.loading = true;
      getPurchaserequisition(id).then((response) => {
        this.purchaserequisition = response.data;
        this.loading = false;
      });
    },
    /** 查询申购材料列表 */
    async getListDetailmaterialsubscription(subscribeID) {
      this.loading = true;
      let total = (await listDetailmaterialsubscription())["total"];
      listDetailmaterialsubscription({
        subscribeID: subscribeID,
        pageSize: total,
      }).then((response) => {
        this.detailmaterialsubscriptionlist = response.rows;
        this.loading = false;
      });
    },
    /** 选中选中申购材料 */
    setDetailmaterialsubscription(id) {
      this.loading = true;
      getDetailmaterialsubscription(id).then((response) => {
        this.detailmaterialsubscription = response.data;
        this.tmp = {
          materialSubscription: null,
          materialID: null,
          name: null,
          materialPrice: null,
          typeName: null,
          specificationsType: null,
          specificationModel: null,
          materialDensity: null,
        };
        setIntersectionObj(this.tmp, this.detailmaterialsubscription);
        setIntersectionObj(this.matlwarehousingdet, this.tmp);
        this.loading = false;
      });
    },
    /** 查询材料信息列表 */
    async getListBasicinformationofmaterials() {
      this.loading = true;
      let total = (await listBasicinformationofmaterials())["total"];
      listBasicinformationofmaterials({ pageSize: total }).then((response) => {
        this.basicinformationofmaterialslist = response.rows;
        this.loading = false;
      });
    },
    /** 选中选中材料信息 */
    setBasicinformationofmaterials(id) {
      this.loading = true;
      getBasicinformationofmaterials(id).then((response) => {
        this.basicinformationofmaterials = response.data;
        this.basicinformationofmaterials.materialID =
          this.basicinformationofmaterials.id;
        this.tmp = {
          materialID: null,
          name: null,
          typeName: null,
          materialPrice: null,
          specificationsType: null,
          specificationModel: null,
          materialDensity: null,
        };
        setIntersectionObj(this.tmp, this.basicinformationofmaterials);
        setIntersectionObj(this.matlwarehousingdet, this.tmp);
        this.loading = false;
      });
    },
    /** 查询发票信息列表 */
    async getListReceiptinvoice() {
      this.loading = true;

      let total = (await listReceiptinvoice())["total"];
      listReceiptinvoice({ pageSize: total }).then((response) => {
        this.receiptinvoicelist = response.rows;
        this.loading = false;
      });
    },
    /** 选中选中发票信息 */
    setReceiptinvoice(id) {
      this.loading = true;
      getReceiptinvoice(id).then((response) => {
        this.receiptinvoice = response.data;
        this.loading = false;
        this.tmp = {
          receiptInvoiceID: null,
          invoiceType: null,
          invoiceTaxRate: null,
          purchaseUnitPriceExcludingTax: null,
          purchaseUnitPriceIncludingTax: null,
        };
        setIntersectionObj(this.tmp, this.receiptinvoice);
        setIntersectionObj(this.matlwarehousingdet, this.tmp);
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.matlwarehousingdet = {
        id: null,
        warehouseEntryID: this.warehouseEntryID,
        materialSubscription: null,
        materialID: null,
        name: null,
        materialPrice: null,
        typeName: null,
        specificationsType: null,
        specificationModel: null,
        materialDensity: null,
        receiptInvoiceID: null,
        invoiceType: null,
        invoiceTaxRate: null,
        purchaseUnitPriceExcludingTax: null,
        purchaseUnitPriceIncludingTax: null,
        receiptQuantity: null,
        sampleURL: null,
        notes: null,
      };
      this.form = {
        id: null,
        warehouseEntryID: null,
        materialSubscription: null,
        receiptInvoiceID: null,
        materialID: null,
        receiptQuantity: null,
        sampleURL: null,
        notes: null,
      };
      // 申购单列表
      this.purchaserequisitionlist = [];
      // 选中申购单
      this.purchaserequisition = {};
      // 申购材料列表
      this.detailmaterialsubscriptionlist = [];
      // 选中申购材料
      this.detailmaterialsubscription = {};
      // 材料信息列表
      this.basicinformationofmaterialslist = [];
      // 选中材料信息
      this.basicinformationofmaterials = {};
      // 发票信息列表
      this.receiptinvoicelist = [];
      // 选中发票信息
      this.receiptinvoice = {};
      this.resetForm("form");
      this.fileList = [];
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
    async handleView(row) {
      this.view_form = row;
      this.view_form.files = [];
      if (row.sampleURL != null) {
        let urls = row.sampleURL.split(";");
        urls.pop();
        console.log(row.sampleURL.split(";"));
        let num = 0;
        for (num in urls) {
          let tmp = await fileDownload(urls[num]);
          this.view_form.files.push(tmp);
          console.log(tmp);
        }
        console.log(this.view_form);
      }

      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getMatlwarehousingdet(id).then((response) => {
        this.matlwarehousingdet = response.data;
        if (this.matlwarehousingdet.materialSubscription != null) {
          getDetailmaterialsubscription(
            this.matlwarehousingdet.materialSubscription
          ).then((response) => {
            this.setPurchaserequisition(response.data.subscribeID);
          });
        }

        this.view_open = true;
        this.title = "材料入库详细";
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.open = true;
      this.view_open = false;
      this.title = "添加材料入库详细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getMatlwarehousingdet(id).then(async (response) => {
        this.matlwarehousingdet = response.data;

        if (response.data.sampleURL != null) {
          let num = 0;
          let urls = response.data.sampleURL.split(";");
          urls.pop();
          for (num in urls) {
            let tmp = await fileDownload(urls[num]);
            this.fileList.push({ url: tmp.getUrl(), raw: tmp.getFile() });
          }
        }
        if (this.matlwarehousingdet.materialSubscription != null) {
          getDetailmaterialsubscription(
            this.matlwarehousingdet.materialSubscription
          ).then((response) => {
            this.setPurchaserequisition(response.data.subscribeID);
          });
        }
        this.open = true;
        this.view_open = false;
        this.title = "修改材料入库详细";
      });
    },
    /** 提交按钮 */
    async submitForm() {
      this.$refs["matlwarehousingdet"].validate(async (valid) => {
        if (valid) {
          setIntersectionObj(this.form, this.matlwarehousingdet);
          await this.fileUpdate();

          if (!this.isadd) {
            updateMatlwarehousingdet(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMatlwarehousingdet(this.form).then((response) => {
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
        .confirm('是否确认删除材料入库详细编号为"' + ids + '"的数据项？')
        .then(function () {
          return delMatlwarehousingdet(ids);
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
        "storage/matlwarehousingdet/export",
        {
          ...this.queryParams,
        },
        `matlwarehousingdet_${new Date().getTime()}.xlsx`
      );
    },
  },
  watch: {
    "$route.query.id": {
      immediate: true,
      handler() {
        this.getExist();
      },
    },
    "this.$route.query.status": {
      immediate: true,
      handler() {
        this.getExist();
      },
    },
  },
};
</script>
