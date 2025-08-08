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

            <el-form-item label="刀具名称" prop="name">
              <el-input
                v-model="queryParams.name"
                placeholder="请输入刀具名称"
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
            <el-form-item label="计量单位" prop="uint">
              <el-input
                v-model="queryParams.uint"
                placeholder="请输入计量单位"
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
      <el-col :span="1.5" v-if="upper_status == '0'">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['storage:DetailsOfToolStorage:add']"
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
          v-hasPermi="['storage:DetailsOfToolStorage:edit']"
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
          v-hasPermi="['storage:DetailsOfToolStorage:remove']"
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
          v-hasPermi="['storage:DetailsOfToolStorage:export']"
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
      :data="DetailsOfToolStorageList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        label="入库单编号"
        align="center"
        prop="warehouseEntryID"
      />

      <el-table-column label="刀具入库id" align="center" prop="id" />

      <el-table-column
        label="刀具基本信息编号"
        align="center"
        prop="toolInformationID"
      />
      <el-table-column label="刀具名称" align="center" prop="name" />
      <el-table-column label="规格型号" align="center" prop="specificationModel" />

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
            v-hasPermi="['storage:DetailsOfToolStorage:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-if="upper_status == '0'"
            v-hasPermi="['storage:DetailsOfToolStorage:edit']"
            >修改</el-button
          >
          <el-button
           v-if="upper_status == '0'"
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['storage:DetailsOfToolStorage:remove']"
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

    <!-- 添加或修改DetailsOfToolStorage对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <div
        style="
          width: 100%;
          height: 600px;
          overflow-y: scroll;
          overflow-x: hidden;
        "
      >
        <el-form
          ref="form"
          :model="form"
          :disabled="view_open"
          :rules="rules"
          label-width="80px"
        >
          <!-- 刀具入库编号 -->
          <el-row :gutter="12">
            <el-col :span="12">
              <el-form-item label="入库单编号" prop="warehouseEntryID">
                <el-input
                  v-model="form.warehouseEntryID"
                  :disabled="true"
                  placeholder="请输入入库单编号"
                /> </el-form-item
            ></el-col>
            <el-col :span="12">
              <el-form-item label="入库数量" prop="receiptQuantity">
                <el-input
                  v-model="form.receiptQuantity"
                  placeholder="请输入入库数量"
                /> </el-form-item
            ></el-col>
          </el-row>

          <!-- 刀具基本信息 -->
          <el-row :gutter="12">
            <el-col :span="12">
              <el-form-item label="刀具基本信息" prop="toolInformationID">
                <el-select
                filterable
                  v-model="form.toolInformationID"
                  placeholder="请选刀具信息"
                  @focus="gettoolinformations()"
                >
                  <el-option
                    v-for="(item, index) in toolinformations"
                    :key="index"
                    :label="item.name"
                    :value="item.id"
                    @click.native="settoolinformation(item.id)"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>

            <el-col :span="12">
              <el-form-item label="刀具名称" prop="name">
                <el-input
                  placeholder="请输入刀具名称"
                  v-model="BasicToolInformation.name"
                  :disabled="true"
                /> </el-form-item
            ></el-col>
          </el-row>

          <el-row :gutter="12">
            <el-col :span="12">
              <el-form-item label="材料类别名称" prop="typeName">
                <el-input
                  placeholder="请输入材料类别名称"
                  v-model="BasicToolInformation.typeName"
                  :disabled="true"
                /> </el-form-item
            ></el-col>

            <el-col :span="12">
              <el-form-item label="规格类型" prop="specificationsType">
                <el-input
                  placeholder="请输入规格类型"
                  v-model="BasicToolInformation.specificationsType"
                  :disabled="true"
                /> </el-form-item
            ></el-col>
          </el-row>

          <el-row :gutter="12">
            <el-col :span="12">
              <el-form-item label="规格型号" prop="specificationModel">
                <el-input
                  placeholder="请输入规格型号"
                  v-model="BasicToolInformation.specificationModel"
                  :disabled="true"
                /> </el-form-item
            ></el-col>

            <el-col :span="12">
              <el-form-item label="计量单位" prop="uint">
                <el-input
                  placeholder="请输入计量单位"
                  v-model="BasicToolInformation.uint"
                  :disabled="true"
                /> </el-form-item
            ></el-col>
          </el-row>
          
           <el-row :gutter="12">
            <el-col :span="12">
              <el-form-item label="刀具价格" >
                <el-input
                  placeholder="请输入刀具价格"
                  v-model="BasicToolInformation.toolPrice"
                  :disabled="true"
                /> </el-form-item
            ></el-col>

            <el-col :span="12">
              <el-form-item label="厂商" >
                <el-input
                  placeholder="请输入厂商"
                  v-model="form.manufacturers"
                /> </el-form-item
            ></el-col>
          </el-row>




          <!-- 发票信息 -->
          <el-row :gutter="12">
            <el-col :span="12">
              <el-form-item label="发票" prop="receiptinvoiceID">
                <el-select
                  filterable
                  v-model="form.receiptInvoiceID"
                  placeholder="请选刀具信息"
                  @focus="getreceiptinvoice()"
                >
                  <el-option
                    v-for="(item, index) in receiptinvoices"
                    :key="index"
                    :label="item.receiptInvoiceID"
                    :value="item.receiptInvoiceID"
                    @click.native="setreceiptinvoice(item.receiptInvoiceID)"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>

            <el-col :span="12">
              <el-form-item label="发票类型" prop="invoiceType">
                <el-input
                  disabled
                  v-model="receiptinvoice.invoiceType"
                  placeholder="请输入发票类型"
                /> </el-form-item
            ></el-col>
          </el-row>
          <el-row :gutter="12"
            ><el-col :span="12">
              <el-form-item label="发票税率" prop="invoiceTaxRate">
                <el-input
                  disabled
                  v-model="receiptinvoice.invoiceTaxRate"
                  placeholder="请输入发票税率"
                /> </el-form-item></el-col
            ><el-col :span="12">
              <el-form-item
                label="不含税采购单价"
                prop="purchaseUnitPriceExcludingTax"
              >
                <el-input
                  disabled
                  v-model="receiptinvoice.purchaseUnitPriceExcludingTax"
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
                  v-model="receiptinvoice.purchaseUnitPriceIncludingTax"
                  placeholder="请输入含税采购单价"
                /> </el-form-item></el-col
          ></el-row>

          <!-- 备注 -->
          <el-row :gutter="12"
            ><el-col :span="12"
              ><el-form-item label="备注" prop="notes">
                <el-input
                  v-model="form.notes"
                  placeholder="请输入备注"
                /> </el-form-item></el-col
          ></el-row>
        </el-form>
      </div>
      <div v-if="!view_open" slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDetailsOfToolStorage } from "@/api/storage/DetailsOfToolStorage";
import {
  getToolStorage,
  delToolStorage,
  addToolStorage,
  updateToolStorage,
} from "@/api/storage/toolStorage"; //原表

//刀具基本信息
import { listToolinformation } from "@/api/storage/toolinformation";

//刀具基本信息的视图
import { getBasicToolInformation } from "@/api/storage/BasicToolInformation";

//发票
import {
  listReceiptinvoice,
  getReceiptinvoice,
} from "@/api/finance/receiptinvoice";
export default {
  name: "DetailsOfToolStorage",
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
      // DetailsOfToolStorage表格数据
      DetailsOfToolStorageList: [],
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

        warehouseEntryID: this.$route.query.id,
        name: null,
        typeName: null,
        specificationsType: null,
        specificationModel: null,
        uint: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [
          { required: true, message: "刀具入库id不能为空", trigger: "blur" },
        ],
        warehouseEntryID: [
          { required: true, message: "入库单编号不能为空", trigger: "blur" },
        ],
        receiptInvoiceID: [
          {
            required: true,
            message: "发票信息编号不能为空",
            trigger: "change",
          },
        ],

        receiptQuantity: [
          { required: true, message: "入库数量不能为空", trigger: "blur" },
        ],

        toolInformationID: [
          {
            required: true,
            message: "刀具基本信息不能为空",
            trigger: "change",
          },
        ],
      },
      //当前入库单编号
      warehouseEntryID: "",
      //父单状态
      upper_status: null,
      //刀具基本信息
      toolinformations: [],

      //通过下拉框最后查找的刀具
      BasicToolInformation: {},
      //发票信息
      receiptinvoices: [],

      //下拉框查找的发票
      receiptinvoice: {},
    };
  },
  created() {
    this.getExist();
  },
  methods: {
    getExist() {
      this.warehouseEntryID = this.$route.query.id;
      this.upper_status = this.$route.query.status;
      this.queryParams.warehouseEntryID = this.warehouseEntryID;
      this.getList();
    },
    /** 查询DetailsOfToolStorage列表 */
    getList() {
      this.loading = true;
      listDetailsOfToolStorage(this.queryParams).then((response) => {
        this.DetailsOfToolStorageList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },

    //刀具基本信息的下拉框
  async  gettoolinformations() {
       let total=  await listToolinformation()['total'];

      this.loading = true;
      listToolinformation({pageSize:total}).then((res) => {
        this.toolinformations = res.rows;
        this.loading = false;
      });
    },

    settoolinformation(id) {
      this.loading = true;
      getBasicToolInformation(id).then((res) => {
        this.BasicToolInformation = res.data;
        this.loading = false;
      });
    },
    //发票信息
   async getreceiptinvoice() {

   let total=  await listReceiptinvoice()['total'];
      this.loading = true;
      listReceiptinvoice({pageSize:total}).then((res) => {
        this.receiptinvoices = res.rows;
        this.loading = false;
      });
    },

    //下拉框查找的发票
    setreceiptinvoice(id) {
      this.loading = true;
      getReceiptinvoice(id).then((res) => {
        this.receiptinvoice = res.data;
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
        warehouseEntryID: this.$route.query.id,
        receiptInvoiceID: null,
        toolInformationID: null,
        manufacturers:null,
        receiptQuantity: null,
        notes: null,
      };
      this.toolinformations = [];
      this.BasicToolInformation = {};
      this.receiptinvoices = [];
      this.receiptinvoice = {};
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
      getToolStorage(id).then((response) => {
        this.form = response.data;
        this.view_open = true;
       getBasicToolInformation(row.toolInformationID).then((res) => {
          this.BasicToolInformation = res.data;
        });
      getReceiptinvoice(row.receiptInvoiceID).then((res) => {
          this.receiptinvoice = res.data;
        });
        this.open = true;
        this.title = "查看刀具入库详细";
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.view_open = false;
      this.reset();
      this.isadd = true;
      this.open = true;
      this.title = "添加刀具入库";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {

      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getToolStorage(id).then((response) => {
        this.form = response.data;
        getBasicToolInformation(row.toolInformationID).then((res) => {
          this.BasicToolInformation = res.data;
        });
        getReceiptinvoice(row.receiptInvoiceID).then((res) => {
          this.receiptinvoice = res.data;
        });
         this.view_open = false;
        this.open = true;
        this.title = "修改刀具入库";
      });
    },

    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateToolStorage(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addToolStorage(this.form).then((response) => {
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
        .confirm(
          '是否确认删除DetailsOfToolStorage编号为"' + ids + '"的数据项？'
        )
        .then(function () {
          return delToolStorage(ids);
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
        "storage/DetailsOfToolStorage/export",
        {
          ...this.queryParams,
        },
        `DetailsOfToolStorage_${new Date().getTime()}.xlsx`
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
