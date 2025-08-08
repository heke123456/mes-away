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
            <el-form-item label="入库单编号" prop="warehouseEntryID">
              <el-input
                v-model="queryParams.warehouseEntryID"
                placeholder="请输入入库单编号"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="id" prop="localmaterialwarehousingID">
              <el-input
                v-model="queryParams.localmaterialwarehousingID"
                placeholder="请输入id"
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
            <el-form-item label="规格型号" prop="specificationModel">
              <el-input
                v-model="queryParams.specificationModel"
                placeholder="请输入规格型号"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="发票税率" prop="invoiceTaxRate">
              <el-input
                v-model="queryParams.invoiceTaxRate"
                placeholder="请输入发票税率"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item
              label="不含税采购单价"
              prop="purchaseUnitPriceExcludingTax"
            >
              <el-input
                v-model="queryParams.purchaseUnitPriceExcludingTax"
                placeholder="请输入不含税采购单价"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item
              label="含税采购单价"
              prop="purchaseUnitPriceIncludingTax"
            >
              <el-input
                v-model="queryParams.purchaseUnitPriceIncludingTax"
                placeholder="请输入含税采购单价"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="申购单编号" prop="subscribeID">
              <el-input
                v-model="queryParams.subscribeID"
                placeholder="请输入申购单编号"
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
          v-hasPermi="['storage:materialWarehousingDetailed:add']"
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
          v-hasPermi="['storage:materialWarehousingDetailed:edit']"
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
          v-hasPermi="['storage:materialWarehousingDetailed:remove']"
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
          v-hasPermi="['storage:materialWarehousingDetailed:export']"
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
      :data="materialWarehousingDetailedList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        label="入库单编号"
        align="center"
        prop="warehouseEntryID"
      />
      <el-table-column
        label="id"
        align="center"
        prop="localmaterialwarehousingID"
      />
      <el-table-column
        label="申购数量"
        align="center"
        prop="subscriptionQuantity"
      />
      <el-table-column label="材料名称" align="center" prop="name" />
      <el-table-column label="类别名称" align="center" prop="typeName" />
      <el-table-column
        label="规格类型"
        align="center"
        prop="specificationsType"
      />
      <el-table-column
        label="规格型号"
        align="center"
        prop="specificationModel"
      />
      <el-table-column label="发票税率" align="center" prop="invoiceTaxRate" />
      <el-table-column label="发票类型" align="center" prop="invoiceType" />
      <el-table-column
        label="不含税采购单价"
        align="center"
        prop="purchaseUnitPriceExcludingTax"
      />
      <el-table-column
        label="含税采购单价"
        align="center"
        prop="purchaseUnitPriceIncludingTax"
      />
      <el-table-column label="申购单编号" align="center" prop="subscribeID" />
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
            v-hasPermi="['storage:materialWarehousingDetailed:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['storage:materialWarehousingDetailed:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['storage:materialWarehousingDetailed:del']"
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
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="入库单编号" prop="warehouseEntryID">
              <el-input
                v-model="form.warehouseEntryID"
                placeholder="请输入入库单编号"
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="申购单编号" prop="subscribeID">
              <el-select
              filterable
                v-model="form.subscribeID"
                placeholder="请选择申购单"
                @focus="getListpurchaserequisition()"
              >
                <el-option
                  v-for="(item, index) in purchaserequisitionlist"
                  :key="index"
                  :label="item.subscribeID"
                  :value="item.subscribeID"
                  @click.native="setPurchaserequisition(item.subscribeID)"
                >
                </el-option>
              </el-select> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="材料名称" prop="name">
              <el-select
              filterable
                :disabled="purchaserequisition.subscribeID == null"
                v-model="form.materialID"
                placeholder="请选择材料名称"
                @focus="getListdetailmaterialsubscription()"
              >
                <el-option
                  v-for="(item, index) in detailmaterialsubscriptionlist"
                  :key="index"
                  :label="item.name"
                  :value="form.materialID"
                  @click.native="
                    setDetailmaterialsubscription(item.materialSubscription)
                  "
                >
                </el-option>
              </el-select> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="申购数量" prop="subscriptionQuantity">
              <el-input
                disabled
                v-model="form.subscriptionQuantity"
                placeholder="请输入申购数量"
              /> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="类别名称" prop="typeName">
              <el-input
                disabled
                v-model="form.typeName"
                placeholder="请输入类别名称"
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item label="规格型号" prop="specificationModel">
              <el-input
                disabled
                v-model="form.specificationModel"
                placeholder="请输入规格型号"
              /> </el-form-item></el-col></el-row
        ><el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item label="材料密度" prop="materialDensity">
              <el-input
                disabled
                v-model="form.materialDensity"
                placeholder="请输入材料密度"
              /> </el-form-item></el-col
          ></el-row
        >
        <el-form-item label="发票">
          <el-select filterable  v-model="form.receiptInvoiceID" placeholder="请选择" @focus="getListreceiptinvoice()">
          <el-option
          v-for="item, index in receiptinvoicelist"
          :key="index"
          :label="item.receiptInvoiceID"
          :value="item.receiptInvoiceID"
          @click.native="setReceiptinvoice(item.receiptInvoiceID)"
          >
          </el-option>
        </el-select>
        </el-form-item>
            <el-form-item label="发票税率" prop="invoiceTaxRate">
              <el-input
                  disabled
                v-model="receiptinvoice.invoiceTaxRate"
                placeholder="请输入发票税率"
              /> </el-form-item>

          <el-row :gutter="12"
          ><el-col :span="12">
            <el-form-item
              label="不含税采购单价"
              prop="purchaseUnitPriceExcludingTax"
            >
              <el-input
              disabled
                v-model="receiptinvoice.purchaseUnitPriceExcludingTax"
                placeholder="请输入不含税采购单价"
              /> </el-form-item></el-col
          ><el-col :span="12">
            <el-form-item
              label="含税采购单价"
              prop="purchaseUnitPriceIncludingTax"
            >
              <el-input
              disabled
                v-model="receiptinvoice.purchaseUnitPriceIncludingTax"
                placeholder="请输入含税采购单价"
              /> </el-form-item></el-col
        ></el-row>
        <el-row :gutter="12"
          >
          <el-col :span="12"
            ><el-form-item label="附样" prop="sampleURL">
              <image-upload
              disabled
                v-model="detailmaterialsubscription.sampleURL"
              /> </el-form-item></el-col
        >
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listMaterialWarehousingDetailed,
  getMaterialWarehousingDetailed,
} from "@/api/storage/materialWarehousingDetailed";
import {
  addLocalmaterialwarehousing,
  updateLocalmaterialwarehousing,
  delLocalmaterialwarehousing
} from "@/api/storage/localmaterialwarehousing.js";
import {
  listBasicinformationofmaterials,
  getBasicinformationofmaterials,
} from "@/api/storage/basicinformationofmaterials.js";
import {
  listPurchaserequisition,
  getPurchaserequisition,
} from "@/api/order/purchaserequisition.js";
import {
  listDetailmaterialsubscription,
  getDetailmaterialsubscription,
} from "@/api/order/detailmaterialsubscription";
import {
  listReceiptinvoice,
  getReceiptinvoice,
} from "@/api/finance/receiptinvoice.js";
export default {
  name: "MaterialWarehousingDetailed",
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
      materialWarehousingDetailedList: [],
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
        localmaterialwarehousingID: null,
        subscriptionQuantity: null,
        name: null,
        typeName: null,
        specificationsType: null,
        specificationModel: null,
        invoiceTaxRate: null,
        invoiceType: null,
        purchaseUnitPriceExcludingTax: null,
        purchaseUnitPriceIncludingTax: null,
        subscribeID: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        warehouseEntryID: [
          { required: true, message: "入库单编号不能为空", trigger: "blur" },
        ],
        localmaterialwarehousingID: [
          { required: true, message: "id不能为空", trigger: "blur" },
        ],
        subscribeID: [
          { required: true, message: "申购单编号不能为空", trigger: "blur" },
        ],
      },
      // 当前选中材料信息
      basicinformationofmaterials: {},
      // 当前选中申购单信息
      purchaserequisition: {},
      // 材料基本信息列表
      basicinformationofmaterialslist: [],
      // 申购单列表
      purchaserequisitionlist: [],
      // 申购材料列表
      detailmaterialsubscriptionlist: [],
      // 当前选中申购材料
      detailmaterialsubscription: {},
      // 入库材料发票列表
      receiptinvoicelist: [],
      // 当前选中入库材料发票
      receiptinvoice: {},
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询材料入库详细列表 */
    getList() {
      this.loading = true;
      listMaterialWarehousingDetailed(this.queryParams).then((response) => {
        this.materialWarehousingDetailedList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询材料详细信息 */
   async getListbasicinformationofmaterials() {
      this.loading = true;
      let total= (await listBasicinformationofmaterials())["total"];
      listBasicinformationofmaterials({pageSize:total}).then((response) => {
        this.basicinformationofmaterialslist = response.rows;
        this.loading = false;
      });
    },
    /** 选中材料详细信息 */
    setBasicinformationofmaterials(id) {
      this.loading = true;
      getBasicinformationofmaterials(id).then((response) => {
        this.basicinformationofmaterials = response.data;
        this.loading = false;
      });
    },
    /** 查询申购单信息 */
  async  getListpurchaserequisition() {
      this.loading = true;
      let total= (await listPurchaserequisition())["total"];
      listPurchaserequisition({pageSize:total}).then((response) => {
        this.purchaserequisitionlist = response.rows;
        this.loading = false;
      });
    },
    /** 选中申购单 */
    setPurchaserequisition(id) {
      this.loading = true;
      getPurchaserequisition(id).then((response) => {
        this.purchaserequisition = response.data;
        this.loading = false;
      });
    },
    /** 查询申购材料列表信息 */
  async  getListdetailmaterialsubscription() {
      this.loading = true;
        let total= (await listDetailmaterialsubscription())["total"];
      listDetailmaterialsubscription({
        pageSize:total,
        subscribeID: this.purchaserequisition.subscribeID,
      }).then((response) => {
        this.detailmaterialsubscriptionlist = response.rows;
        this.loading = false;
      });
    },
    /** 选中申购材料 */
    setDetailmaterialsubscription(id) {
      this.loading = true;
      getDetailmaterialsubscription(id).then((response) => {
        this.detailmaterialsubscription = response.data;
        console.log(response);
        this.form.subscriptionQuantity =
          this.detailmaterialsubscription.subscriptionQuantity;
        this.form.typeName = this.detailmaterialsubscription.typeName;
        this.form.specificationModel =
          this.detailmaterialsubscription.specificationModel;
        this.form.materialDensity =
          this.detailmaterialsubscription.materialDensity;
        this.loading = false;
      });
    },
    /** 查询入库材料发票 */
   async getListreceiptinvoice() {
      this.loading = true;
       let total= (await listReceiptinvoice())["total"];
      listReceiptinvoice({pageSize:total}).then((response) => {
        this.receiptinvoicelist = response.rows;
        this.loading = false;
      });
    },
    /** 选中入库材料发票 */
    setReceiptinvoice(receiptInvoiceID) {
      this.loading = true;
      getReceiptinvoice(receiptInvoiceID).then((response) => {
        this.receiptinvoice = response.data;
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
        materialSubscription: null,
        receiptInvoiceID: null,
        materialID: null,
        receiptQuantity: null,
        sampleURL: null,
        notes: null,
      };
      // 当前选中材料信息
      this.basicinformationofmaterials = {};
      // 当前选中申购单信息
      this.purchaserequisition = {};
      // 材料基本信息列表
      this.basicinformationofmaterialslist = [];
      // 申购单列表
      this.purchaserequisitionlist = [];
      // 申购材料列表
      this.detailmaterialsubscriptionlist = [];
      // 当前选中申购材料
      this.detailmaterialsubscription = {};
      // 入库材料发票列表
      this.receiptinvoicelist =  [];
      // 当前选中入库材料发票
      this.receiptinvoice ={};
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
      this.ids = selection.map((item) => item.warehouseEntryID);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    handleView(row) {
      this.view_open = true;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.open = true;
      this.title = "添加材料入库详细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const warehouseEntryID = row.warehouseEntryID || this.ids;
      getMaterialWarehousingDetailed(warehouseEntryID).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改材料入库详细";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          console.log(this.form);
          if (!this.isadd) {
            updateLocalmaterialwarehousing(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLocalmaterialwarehousing(this.form).then((response) => {
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
      const warehouseEntryIDs = row.warehouseEntryID || this.ids;
      this.$modal
        .confirm(
          '是否确认删除材料入库详细编号为"' + warehouseEntryIDs + '"的数据项？'
        )
        .then(function () {
          return delLocalmaterialwarehousing(warehouseEntryIDs);
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
        "storage/materialWarehousingDetailed/export",
        {
          ...this.queryParams,
        },
        `materialWarehousingDetailed_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
