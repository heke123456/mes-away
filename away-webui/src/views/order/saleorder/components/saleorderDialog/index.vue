<template>
  <!-- 查看订单详细信息 -->
  <el-dialog
    :title="view_form.id"
    :visible.sync="view_open"
    width="900px"
    append-to-body
  >
    <el-descriptions :column="2" border>
      <el-descriptions-item label="创建时间">{{
        view_form.createTime
      }}</el-descriptions-item>
      <el-descriptions-item label="创建人">{{
        view_form.createUserName
      }}</el-descriptions-item>
    </el-descriptions>
    <el-descriptions title="合同信息" :column="2" border>
      <el-descriptions-item label="订单编号">{{
        view_form.id
      }}</el-descriptions-item>
      <el-descriptions-item label="下单日期">{{
        view_form.orderDate
      }}</el-descriptions-item>
      <el-descriptions-item label="客户编号">{{
        view_form.customerID
      }}</el-descriptions-item>
      <el-descriptions-item label="客户名称">{{
        view_form.customername
      }}</el-descriptions-item>
      <el-descriptions-item label="产品编号">{{
        view_form.productID
      }}</el-descriptions-item>
      <el-descriptions-item label="产品名称">{{
        view_form.productname
      }}</el-descriptions-item>
      <el-descriptions-item label="产品图纸" :span="2">
        <filedown :files="view_form.productfiles" />
      </el-descriptions-item>
      <el-descriptions-item label="需求数量">{{
        view_form.number
      }}</el-descriptions-item>
      <el-descriptions-item label="批次号">{{
        view_form.lotNumber
      }}</el-descriptions-item>
      <el-descriptions-item label="要求交期">{{
        view_form.requiredDeliveryTime
      }}</el-descriptions-item>
      <el-descriptions-item label="客供材料">{{
        view_form.iscustomersuppliedmaterials == "0" ? "否" : "是"
      }}</el-descriptions-item>
      <el-descriptions-item label="合同编号">{{
        view_form.contractID
      }}</el-descriptions-item>
      <el-descriptions-item label="合同金额">{{
        view_form.contractmoney
      }}</el-descriptions-item>
      <el-descriptions-item label="合同附件" :span="2">
        <filedown :files="view_form.contractfiles" />
      </el-descriptions-item>
    </el-descriptions>
    <el-descriptions title="发票信息" :column="2" border>
      <el-descriptions-item label="发票类型">{{
        view_form.invoiceType
      }}</el-descriptions-item>
      <el-descriptions-item label="发票编号">{{
        view_form.invoiceID
      }}</el-descriptions-item>
      <el-descriptions-item label="开票时间">{{
        view_form.invoiceCreateTime
      }}</el-descriptions-item>
      <el-descriptions-item label="开票数量">{{
        view_form.invoiceNumer
      }}</el-descriptions-item>
      <el-descriptions-item label="税率">{{
        view_form.taxRate
      }}</el-descriptions-item>
      <el-descriptions-item label="税费">{{
        view_form.taxation
      }}</el-descriptions-item>
      <el-descriptions-item label="销售单价(不含税)">{{
        view_form.salesUnitPriceExcludingTax
      }}</el-descriptions-item>
      <el-descriptions-item label="销售单价(含税)">{{
        view_form.salesUnitPriceIncludingTax
      }}</el-descriptions-item>
      <el-descriptions-item label="销售金额(不含税)">{{
        view_form.consumptionAmountExcludingTax
      }}</el-descriptions-item>
      <el-descriptions-item label="销售金额(含税)">{{
        view_form.consumptionAmountIncludingTax
      }}</el-descriptions-item>
      <el-descriptions-item label="对账日期">{{
        view_form.reconciliationDate
      }}</el-descriptions-item>
      <el-descriptions-item label="客户对账人员">{{
        view_form.customerReconciliationPersonnel
      }}</el-descriptions-item>
    </el-descriptions>
    <el-descriptions :column="2" border>
      <el-descriptions-item label="备注" :span="2">{{
        view_form.note
      }}</el-descriptions-item>
    </el-descriptions>
    <el-descriptions
      v-if="additionals.length > 0"
      title="附加信息"
      :column="2"
      border
    >
      <el-descriptions-item
        v-for="(item, index) in additionals"
        :key="index"
        :label="item.key"
        :span="2"
        >{{ item.value }}</el-descriptions-item
      >
    </el-descriptions>
  </el-dialog>
</template>

<script>
import {
  listSaleorder,
  getSaleorder,
  delSaleorder,
  addSaleorder,
  updateSaleorder,
} from "@/api/order/saleorder";
import { listCustom } from "@/api/comprehensive/custom";
import { listInvoice } from "@/api/finance/invoice";
import { listProduct } from "@/api/order/product";
import { listCustomersuppliedmaterials } from "@/api/storage/customersuppliedmaterials";
import { listContract } from "@/api/order/contract";
import { fileDownload } from "@/api/file/file";
import { listAdditional } from "@/api/order/additional";
import filedown from "@/components/FileDown/filedown.vue";

export default {
  name: "saleorderDialog",
  components: { filedown: filedown },
  data() {
    return {
      view_open: false,
      view_form: [],
      additionals: [],
      row: [],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询订单列表 */
    getList() {
      this.loading = true;
      listSaleorder(this.queryParams).then((response) => {
        this.saleorderList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询客户信息 */
    getListCustom() {
      listCustom({}).then((response) => {
        this.customs = response.rows;
      });
    },
    /** 查询发票信息 */
    getListInvoice() {
      listInvoice({}).then((response) => {
        this.invoices = response.rows;
      });
    },
    /** 查询产品信息 */
    getListProduct() {
      listProduct({}).then((response) => {
        this.products = response.rows;
      });
    },
    /** 查询库存客供材料信息*/
    getListCustomersuppliedmaterials() {
      listCustomersuppliedmaterials({}).then((response) => {
        this.customersuppliedmaterialss = response.rows;
      });
    },
    /** 查询合同信息*/
    getListContract() {
      listContract({}).then((response) => {
        this.contracts = response.rows;
      });
    },
    /** 产品图纸下载 */
    async productFileDown(file_name) {
      let tmp = await fileDownload(file_name);

      this.view_form.productfiles.push(tmp);
    },
    /** 合同附件下载 */
    async customerFileDown(file_name) {
      let tmp = await fileDownload(file_name);
      this.view_form.contractfiles.push(tmp);
    },
    /** 获取订单对应附加信息 */
    async getListAdditional(id) {
      this.additionals = [];
      let total = (await listAdditional())["total"];
      let response = await listAdditional({ saleorderID: id, pageSize: total });
      let datas = response.rows;
      let num = 0;
      for (num in datas) {
        let line = datas[num];
        this.additionals.push({
          id: line.id,
          saleorderID: line.saleorderID,
          key: line.key,
          value: line.value,
        });
      }
    },
    // 取消按钮
    cancel() {
      this.view_open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        createUserName: null,
        number: null,
        requiredDeliveryTime: null,
        customerID: null,
        productID: null,
        contractID: null,
        invoiceID: null,
        iscustomersuppliedmaterials: 0,
        state: null,
      };
      this.resetForm("form");
    },
    /** 查看产品详细信息 */
    async handleProductView(row) {
      if (row.productdrawingURL == null) {
        return 0;
      } else {
        let urls = row.productdrawingURL.split(";");
        urls.pop();
        let num = 0;
        for (num in urls) {
          await this.productFileDown(urls[num]);
        }
      }
    },
    /** 查看合同详细信息 */
    async handleCustomerView(row) {
      if (row.contractURL == null) {
        return 0;
      } else {
        let urls = row.contractURL.split(";");
        urls.pop();
        let num = 0;
        for (num in urls) {
          await this.customerFileDown(urls[num]);
        }
      }
    },
    /** 查看详细按钮 */
    async handleView(row) {
      this.view_form = row;
      this.view_form.productfiles = [];
      this.view_form.contractfiles = [];
      await this.handleProductView(row);
      await this.handleCustomerView(row);
      await this.getListAdditional(row.id);
      this.view_open = true;
    },
  },
};
</script>

<style></style>
