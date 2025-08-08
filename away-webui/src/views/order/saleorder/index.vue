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
      <el-form-item label="下单日期" prop="createTime">
        <el-date-picker
          clearable
          v-model="queryParams.createTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择下单日期"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="要求交期" prop="requiredDeliveryTime">
        <el-date-picker
          clearable
          v-model="queryParams.requiredDeliveryTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择要求交期"
        >
        </el-date-picker>
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
          v-hasPermi="['order:saleorder:add']"
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
          v-hasPermi="['order:saleorder:edit']"
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
          v-hasPermi="['order:saleorder:remove']"
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
          v-hasPermi="['order:saleorder:export']"
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
      :data="saleorderList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="订单id" align="center" prop="id" />
      <el-table-column
        label="创建日期"
        align="center"
        prop="createTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建人" align="center" prop="createUserName" />
      <el-table-column
        label="下单日期"
        align="center"
        prop="createTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.orderDate, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="需求数量" align="center" prop="number" />
      <el-table-column
        label="要求交期"
        align="center"
        prop="requiredDeliveryTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{
            parseTime(scope.row.requiredDeliveryTime, "{y}-{m}-{d}")
          }}</span>
        </template>
      </el-table-column>
      <el-table-column label="客户名称" align="center" prop="customername" />
      <el-table-column label="状态" align="center" prop="state">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.aw_order_saleoder_options"
            :value="scope.row.state"
          />
        </template>
      </el-table-column>
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
            v-hasPermi="['order:saleorder:query']"
            >查看</el-button
          >
          <el-button
            v-if="scope.row.state == '未发布'"
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleRelease(scope.row)"
            v-hasPermi="['order:saleorder:edit']"
            >发布</el-button
          >
          <el-button
            v-if="scope.row.state == '未发布'"
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['order:saleorder:edit']"
            >修改</el-button
          >
          <el-button
            v-if="scope.row.state == '未发布'"
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['order:saleorder:remove']"
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

    <!-- 添加或修改订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <!-- 第一行 创建人 下单日期 -->
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="创建人" prop="createUserName">
              <div>{{ form.createUserName }}</div>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="下单日期" prop="orderDate">
              <el-date-picker
                clearable
                v-model="form.orderDate"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择下单日期"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 第二行 需求数量 要求交期 -->
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="需求数量" prop="number">
              <el-row :gutter="15">
                <el-col :span="15">
                  <el-input
                    type="number"
                    v-model="form.number"
                    placeholder="请输入需求数量"
                  />
                </el-col>
              </el-row>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="要求交期" prop="requiredDeliveryTime">
              <el-date-picker
                clearable
                v-model="form.requiredDeliveryTime"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择要求交期"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="批次号" prop="lotNumber">
              <el-input v-model="form.lotNumber" placeholder="请输入批次号">
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 第三行 客户信息 产品信息 -->
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="客户信息" prop="customerID">
              <el-select
                v-model="form.customerID"
                placeholder="请选择订单客户"
                filterable
              >
                <el-option
                  v-for="item in customs"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="产品信息" prop="productID">
              <el-select
                v-model="form.productID"
                placeholder="请选择产品"
                filterable
              >
                <el-option
                  v-for="item in products"
                  :key="item.id"
                  :label="item.name"
                  :value="String(item.id)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 第四行 材料是否客供 客供材料信息 -->
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item
              label-width="200"
              label="材料是否客供"
              prop="iscustomersuppliedmaterials"
            >
              <el-radio-group v-model="form.iscustomersuppliedmaterials">
                <el-radio
                  v-for="dict in dict.type.aw_oder_customer_status"
                  :key="dict.value"
                  :label="dict.value"
                  >{{ dict.label }}</el-radio
                >
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 第五行 合同信息 发票信息 -->
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="合同信息" prop="contractID">
              <el-select
                v-model="form.contractID"
                placeholder="请选择合同信息"
                filterable
              >
                <el-option
                  v-for="item in contracts"
                  :key="item.id"
                  :label="item.name"
                  :value="String(item.id)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="发票信息" prop="invoiceID">
              <el-select
                v-model="form.invoiceID"
                placeholder="请选择合同信息"
                filterable
              >
                <el-option
                  v-for="item in invoices"
                  :key="item.id"
                  :label="item.name"
                  :value="String(item.id)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 第六行 订单状态 -->
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="订单状态" prop="state">
              <el-select
                disabled
                v-model="form.state"
                value-key="value"
                placeholder="请选择订单状态"
              >
                <el-option
                  v-for="dict in dict.type.aw_order_saleoder_options"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 第七行 备注 -->
        <el-row :gutter="12">
          <el-col :span="22">
            <el-form-item label="备注" prop="note">
              <el-input
                v-model="form.note"
                type="textarea"
                placeholder="备注"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 附加信息 -->
        <el-divider>
          <span style="font-size: 1.2em">附加信息</span>
        </el-divider>
        <div
          style="
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
          "
        >
          <el-button
            v-if="additionals.length < 1"
            size="mini"
            type="primary"
            icon="el-icon-plus"
            @click="handleAddAdditional"
          ></el-button>
        </div>
        <div
          style="
            display: flex;
            flex-direction: column;
            align-items: center;
            max-height: 200px;
            overflow-y: auto;
          "
        >
          <div v-for="(item, index) in additionals" :key="index">
            <el-form-item label-width="200" :label="'附加信息' + (index + 1)">
              <el-row :gutter="10">
                <el-col :span="6"
                  ><el-input v-model="item.key" placeholder="字段名"
                /></el-col>
                <el-col :span="6"
                  ><el-input v-model="item.value" placeholder="值"
                /></el-col>
                <el-col :span="6">
                  <el-button
                    size="mini"
                    type="text"
                    icon="el-icon-plus"
                    @click="handleAddAdditional"
                    >新增</el-button
                  >
                  <el-button
                    size="mini"
                    type="text"
                    icon="el-icon-minus"
                    @click="headledDeladditional(index, item)"
                    >删除</el-button
                  ></el-col
                >
              </el-row>
            </el-form-item>
          </div>
        </div>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 查看订单详细信息 -->
    <saleorderDialog ref="saleorderDialog" />
  </div>
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
import filedown from "@/components/FileDown/filedown.vue";
import {
  listAdditional,
  delAdditional,
  addAdditional,
  updateAdditional,
} from "@/api/order/additional";
import SaleorderDialog from "./components/saleorderDialog/index";
import store from "@/store";

export default {
  name: "Saleorder",
  components: { filedown: filedown },
  dicts: ["aw_order_saleoder_options", "aw_oder_customer_status"],

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
      // 订单表格数据
      saleorderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示订单详细信息
      view_open: false,
      // 是否新建
      isadd: true,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        createTime: null,
        requiredDeliveryTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        orderDate: [
          { required: true, message: "下单日期不能为空", trigger: "blur" },
        ],
        createUserName: [
          { required: true, message: "创建人不能为空", trigger: "blur" },
        ],
        number: [
          { required: true, message: "需求数量不能为空", trigger: "blur" },
        ],
        requiredDeliveryTime: [
          { required: true, message: "要求交期不能为空", trigger: "blur" },
        ],
        customerID: [
          { required: true, message: "客户信息不能为空", trigger: "blur" },
        ],
        productID: [
          { required: true, message: "产品信息不能为空", trigger: "blur" },
        ],
        iscustomersuppliedmaterials: [
          { required: true, message: "请选择是否客供材料", trigger: "blur" },
        ],
        lotNumber: [
          { required: true, message: "批次号不能为空", trigger: "blur" },
        ],
        state: [
          {
            required: true,
            message: "当前订单状态不能为空",
            trigger: "change",
          },
        ],
      },
      // 订单状态
      state_options: [
        { key: "0", value: "未发布" },
        { key: "1", value: "发布" },
        { key: "2", value: "暂停" },
        { key: "3", value: "完成" },
        { key: "4", value: "取消" },
      ],
      // 材料是否客供
      iscustomersuppliedmaterials: [
        { key: 0, value: "否" },
        { key: 1, value: "是" },
      ],
      // 客户信息
      customs: [],
      // 发票信息
      invoices: [],
      // 产品信息
      products: [],
      // 库存客供材料信息
      customersuppliedmaterialss: [],
      // 合同信息
      contracts: [],
      // 订单详细查看
      view_form: [],
      // 附加信息列表
      additionals: [],
      // 需要删除附加信息列表
      del_additionals: [],
      view_row: [],
    };
  },
  components: {
    saleorderDialog: SaleorderDialog,
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
    async getListCustom() {
      let total = (await listCustom())["total"];
      listCustom({ pageSize: total }).then((response) => {
        this.customs = response.rows;
      });
    },
    /** 查询发票信息 */
    async getListInvoice() {
      let total = (await listInvoice())["total"];
      listInvoice({ pageSize: total }).then((response) => {
        this.invoices = response.rows;
      });
    },
    /** 查询产品信息 */
    async getListProduct() {
      let total = (await listProduct())["total"];
      listProduct({ pageSize: total }).then((response) => {
        this.products = response.rows;
      });
    },
    /** 查询库存客供材料信息*/
    // getListCustomersuppliedmaterials() {
    //   listCustomersuppliedmaterials({}).then(response => {
    //     this.customersuppliedmaterialss = response.rows;
    //   })
    // },
    /** 查询合同信息*/
    async getListContract() {
      let total = (await listContract({ state: "1" }))["total"];
      listContract({ pageSize: total }).then((response) => {
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
      let response = await listAdditional({ pageSize:total,saleorderID: id });
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
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        createUserName: store.getters.name,
        number: null,
        requiredDeliveryTime: null,
        customerID: null,
        productID: null,
        contractID: null,
        invoiceID: null,
        iscustomersuppliedmaterials: "0",
        lotNumber: null,
        state: "0",
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
    /** 状态调整 */
    setStatus(row, status) {
      this.reset();
      this.loading = true;
      const id = row.id;
      getSaleorder(id).then((response) => {
        this.form = response.data;
        this.form.state = status;
        updateSaleorder(this.form).then((response) => {
          this.$modal.msgSuccess("状态变更成功");
          this.open = false;
          this.getList();
          this.loading = false;
        });
      });
    },
    /** 发布按钮操作 */
    handleRelease(row) {
      this.setStatus(row, "1");
    },
    // 添加附加信息
    handleAddAdditional() {
      this.additionals.push({ key: "", value: "" });
    },
    // 删除附加信息
    headledDeladditional(index, item) {
      this.additionals.splice(index, 1);
      if (item.id != null) {
        this.del_additionals.push(item.id);
      }
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.id);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
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
      await this.$refs.saleorderDialog.handleView(row);
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.additionals = [];
      this.reset();
      this.getListCustom();
      this.getListInvoice();
      this.getListProduct();
      this.getListContract();
      // this.getListCustomersuppliedmaterials();
      this.open = true;

      this.title = "添加订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.del_additionals = [];
      this.reset();
      this.getListCustom();
      this.getListInvoice();
      this.getListProduct();
      this.getListContract();
      // this.getListCustomersuppliedmaterials();
      const id = row.id || this.ids;
      getSaleorder(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改订单";
      });
      this.getListAdditional(id);
    },
    /** 提交按钮 */
    async submitForm() {
      let saleorderID;
      this.$refs["form"].validate(async (valid) => {
        if (valid) {
          let response = null;
          if (this.form.id != null) {
            saleorderID = this.form.id;
            response = await updateSaleorder(this.form);
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          } else {
            response = await addSaleorder(this.form);
            saleorderID = response.id;
            this.$modal.msgSuccess("新增成功");
            this.open = false;
            this.getList();
          }

          if (response.code == 200) {
            // 插入或更新附加信息
            if (this.additionals.length > 0) {
              let tmp_additional_add_form = [];
              let tmp_additional_update_form = [];
              let num = 0;
              for (num in this.additionals) {
                if (this.additionals[num].id != null) {
                  tmp_additional_update_form.push(this.additionals[num]);
                } else if (this.additionals.id == null) {
                  let tmp = this.additionals[num];
                  tmp["saleorderID"] = saleorderID;
                  tmp_additional_add_form.push(tmp);
                }
              }

              if (tmp_additional_add_form.length > 0) {
                let num = 0;
                for (num in tmp_additional_add_form) {
                  let response = await addAdditional(
                    tmp_additional_add_form[num]
                  );
                }
              }
              if (tmp_additional_update_form.length > 0) {
                let num = 0;
                for (num in tmp_additional_update_form) {
                  let response = await updateAdditional(
                    tmp_additional_update_form[num]
                  );
                }
              }
              if (this.del_additionals.length > 0) {
                let num;
                for (num in this.del_additionals) {
                  let response = await delAdditional(this.del_additionals[num]);
                }
              }
            }
          }
        }
      });
    },
    /** 删除按钮操作 */
    async handleDelete(row) {
      const ids = row.id || this.ids;
      await this.$modal
        .confirm('是否确认删除订单编号为"' + ids + '"的数据项？')
        .then(async () => {
          return delSaleorder(ids);
        })
        .then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download(
        "order/saleorder/export",
        {
          ...this.queryParams,
        },
        `saleorder_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
