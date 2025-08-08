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
      <el-form-item label="材料基础信息编号" prop="materialID">
        <el-input
          v-model="queryParams.materialID"
          placeholder="请输入材料基础信息编号"
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
      <el-form-item label="工艺编号" prop="processingTechnologyID">
        <el-input
          v-model="queryParams.processingTechnologyID"
          placeholder="请输入工艺编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出库数量" prop="outboundQuantity">
        <el-input
          v-model="queryParams.outboundQuantity"
          placeholder="请输入出库数量"
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

      <el-form-item label="材料名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入材料名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注信息" prop="materialPrice">
        <el-input
          v-model="queryParams.materialPrice"
          placeholder="请输入备注信息"
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
          v-if="upper_status == '0'"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['storage:DetailCustomerMaterialOutbound:add']"
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
          v-hasPermi="['storage:DetailCustomerMaterialOutbound:edit']"
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
          v-hasPermi="['storage:DetailCustomerMaterialOutbound:remove']"
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
          v-hasPermi="['storage:DetailCustomerMaterialOutbound:export']"
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
      :data="DetailCustomerMaterialOutboundList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        label="出库单编号"
        align="center"
        prop="deliveryNoteID"
      />
      <el-table-column
        label="材料基础信息编号"
        align="center"
        prop="materialID"
      />
      <el-table-column
        label="任务编号"
        align="center"
        prop="productionTasksID"
      />
      <el-table-column
        label="工艺编号"
        align="center"
        prop="processingTechnologyID"
      />

      <el-table-column label="材料名称" align="center" prop="name" />
      <el-table-column label="材料价格" align="center" prop="materialPrice" />
      <el-table-column
        label="规格型号"
        align="center"
        prop="specificationModel"
      />

      <el-table-column
        label="出库数量"
        align="center"
        prop="outboundQuantity"
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
            v-hasPermi="['storage:DetailCustomerMaterialOutbound:query']"
            >查看</el-button
          >
          <el-button
            v-if="upper_status == '0'"
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['storage:DetailCustomerMaterialOutbound:edit']"
            >修改</el-button
          >
          <el-button
            v-if="upper_status == '0'"
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['storage:DetailCustomerMaterialOutbound:remove']"
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

    <!-- 添加或修改客供材料出库详细对话框 -->
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
            <el-form-item label="出库单编号" prop="deliveryNoteID">
              <el-input
                disabled
                v-model="form.deliveryNoteID"
                placeholder="请输入出库单编号"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="生产任务单编号">
              <el-select
                filterable
                placeholder="请输入生产任务单编号"
                @focus="getListProductiontasklist()"
                v-model="productiontasklist.id"
              >
                <el-option
                  v-for="(item, index) in productiontasklistlist"
                  :key="index"
                  :value="item.id"
                  :label="item.referred"
                  @click.native="setProductiontasklist(item.id)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="任务编号" prop="productionTasksID">
              <el-select
                filterable
                :disabled="productiontasklist.id == null"
                v-model="form.productionTasksID"
                placeholder="请输入任务编号"
                @focus="getListProductiontasks(productiontasklist.id)"
              >
                <el-option
                  v-for="(item, index) in productiontaskslist"
                  :key="index"
                  :value="item.id"
                  :label="item.id"
                  @click.native="setProductiontasks(item.id)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="工艺编号" prop="processingTechnologyID">
              <el-select
                filterable
                :disabled="productiontasklist.id == null"
                @focus="
                  getprocessingtechnologyList(
                    productiontasks.processingTechnologyID
                  )
                "
                v-model="form.processingTechnologyID"
                placeholder="请输入工艺编号"
              >
                <el-option
                  v-for="(item, index) in processingtechnologyList"
                  :key="index"
                  :value="item.id"
                  :label="item.id"
                  @click.native="setprocessingtechnology(item.id)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="出库数量" prop="outboundQuantity">
              <el-input
                v-model="form.outboundQuantity"
                placeholder="请输入出库数量"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="材料基础信息编号">
              <el-select
                filterable
                :disabled="processingtechnology.id == null"
                v-model="form.materialID"
                placeholder="请输入材料基础信息编号"
                @focus="
                  getMaterialListOfTechnologyList(processingtechnology.id)
                "
              >
                <el-option
                  v-for="(item, index) in MaterialListOfTechnologyList"
                  :key="index"
                  :value="item.materialID"
                  :label="item.materialID"
                  @click.native="setMaterialListOfTechnology(item.id)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="材料名称">
              <el-input
                disabled
                v-model="MaterialListOfTechnology.name"
                placeholder="请输入材料名称"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="材料价格">
              <el-input
                disabled
                v-model="MaterialListOfTechnology.materialPrice"
                placeholder="请输入材料价格"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="材料密度">
              <el-input
                disabled
                v-model="MaterialListOfTechnology.materialDensity"
                placeholder="请输入材料密度"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="类别名称">
              <el-input
                disabled
                v-model="MaterialListOfTechnology.typeName"
                placeholder="请输入类别名称"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="规格型号">
              <el-input
                disabled
                v-model="MaterialListOfTechnology.specificationModel"
                placeholder="请输入规格型号"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="规格类型">
              <el-input
                disabled
                v-model="MaterialListOfTechnology.specificationsType"
                placeholder="请输入备注"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="备注">
              <el-input v-model="form.notes" placeholder="请输入备注" />
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
import {
  listDetailCustomerMaterialOutbound,
  getDetailCustomerMaterialOutbound,
} from "@/api/storage/DetailCustomerMaterialOutbound";

import {
  listProductiontasklist,
  getProductiontasklist,
} from "@/api/produce/productiontasklist.js";

import {
  listProductiontasks,
  getProductiontasks,
} from "@/api/produce/productiontasks.js";
import {
  listProcessingtechnology,
  getProcessingtechnology,
} from "@/api/produce/processingtechnology";

import {
  listMaterialListOfTechnology,
  getMaterialListOfTechnology,
} from "@/api/produce/MaterialListOfTechnology.js";

import {
  delCustomerMaterialsOutbound,
  addCustomerMaterialsOutbound,
  updateCustomerMaterialsOutbound,
} from "@/api/storage/CustomerMaterialsOutbound";

import { getBasicinformationofmaterials } from "@/api/storage/basicinformationofmaterials";

export default {
  name: "DetailCustomerMaterialOutbound",
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
      // 客供材料出库详细表格数据
      DetailCustomerMaterialOutboundList: [],
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
        deliveryNoteID: null,
        materialID: null,
        productionTasksID: null,
        processingTechnologyID: null,
        outboundQuantity: null,
        notes: null,
        productionTasksFormID: null,
        name: null,
        materialPrice: null,
        materialDensity: null,
        typeName: null,
        specificationsType: null,
        specificationModel: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [{ required: true, message: "id不能为空", trigger: "blur" }],
        deliveryNoteID: [
          { required: true, message: "出库单编号不能为空", trigger: "blur" },
        ],
        materialID: [
          {
            required: true,
            message: "材料基础信息编号不能为空",
            trigger: "blur",
          },
        ],
        outboundQuantity: [
          { required: true, message: "出库数量不能为空", trigger: "blur" },
        ],
        productionTasksFormID: [
          {
            required: true,
            message: "生产任务单编号不能为空",
            trigger: "blur",
          },
        ],
        name: [
          { required: true, message: "材料名称不能为空", trigger: "blur" },
        ],
        materialDensity: [
          { required: true, message: "材料密度不能为空", trigger: "blur" },
        ],
      },
      deliveryNoteID: "",
      upper_status: "",
      // 任务单列表
      productiontasklistlist: [],
      // 当前选中任务单
      productiontasklist: {},
      // 任务列表
      productiontaskslist: [],
      // 当前选中任务
      productiontasks: {},
      //生产工艺单列表
      processingtechnologyList: [],
      //当前选中工艺单
      processingtechnology: {},
      //工艺材料列表
      MaterialListOfTechnologyList: [],
      //当前选中的工艺材料列表
      MaterialListOfTechnology: {},
    };
  },
  created() {
    this.getExist();
  },
  methods: {
    /** 查询客供材料出库详细列表 */
    getList() {
      this.loading = true;
      listDetailCustomerMaterialOutbound(this.queryParams).then((response) => {
        this.DetailCustomerMaterialOutboundList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },

    getExist() {
      this.deliveryNoteID = this.$route.query.id;
      this.queryParams.deliveryNoteID = this.deliveryNoteID;
      this.upper_status = this.$route.query.status;

      this.getList();
    },
    //查询任务列表

    async getListProductiontasklist() {
      this.loading = true;
      let total = (await listProductiontasklist())["total"];
      listProductiontasklist({ pageSize: total }).then((response) => {
        this.productiontasklistlist = response.rows;
        this.loading = false;
      });
    },
    /** 选中当前选中任务单 */
    setProductiontasklist(id) {
      this.loading = true;
      getProductiontasklist(id).then((response) => {
        this.productiontasklist = response.data;
        this.loading = false;
      });
    },
    /** 查询任务列表 */
    async getListProductiontasks(productionTasksFormID) {
      this.loading = true;
      let total = (await listProductiontasks())["total"];
      listProductiontasks({
        productionTasksFormID: productionTasksFormID,
        pageSize: total,
      }).then((response) => {
        this.productiontaskslist = response.rows;
        this.loading = false;
      });
    },
    /** 选中当前选中任务 */
    setProductiontasks(id) {
      this.loading = true;
      getProductiontasks(id).then((response) => {
        this.productiontasks = response.data;
        this.loading = false;
      });
    },
    // 查询生产工艺单列表
    async getprocessingtechnologyList(processingtechnologyID) {
      this.loading = true;
      let total = (await listProcessingtechnology())["total"];
      listProcessingtechnology({
        id: processingtechnologyID,
        pageSize: total,
      }).then((response) => {
        this.processingtechnologyList = response.rows;
        this.loading = false;
      });
    },

    //选中生产工艺单
    setprocessingtechnology(id) {
      this.loading = true;
      getProcessingtechnology(id).then((response) => {
        this.processingtechnology = response.data;
        this.loading = false;
      });
    },

    //拿到工艺材料列表

    async getMaterialListOfTechnologyList(processingTechnologyID) {
      let total = (await listMaterialListOfTechnology())["total"];
      listMaterialListOfTechnology({
        pageSize: total,
        processingTechnologyID: processingTechnologyID,
      }).then((response) => {
        this.MaterialListOfTechnologyList = response.rows;
      });
    },

    //选中当前的工艺材料

    setMaterialListOfTechnology(id) {
      getMaterialListOfTechnology(id).then((response) => {
        this.MaterialListOfTechnology = response.data;
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
        deliveryNoteID: this.$route.query.id,
        materialID: null,
        productionTasksID: null,
        processingTechnologyID: null,
        outboundQuantity: null,
        notes: null,
        productionTasksFormID: null,
        name: null,
        materialPrice: null,
        materialDensity: null,
        typeName: null,
        specificationsType: null,
        specificationModel: null,
      };

      (this.productiontasklistlist = []),
        // 当前选中任务单
        (this.productiontasklist = {}),
        // 任务列表
        (this.productiontaskslist = []),
        // 当前选中任务
        (this.productiontasks = {}),
        //生产工艺单列表
        (this.processingtechnologyList = []),
        //当前选中工艺单
        (this.processingtechnology = {}),
        (this.MaterialListOfTechnologyList = []),
        //当前选中的工艺材料列表
        (this.MaterialListOfTechnology = {});
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
      this.view_open = true;
      this.reset();
      const id = row.id || this.ids;
      getDetailCustomerMaterialOutbound(id).then((response) => {
        this.form = response.data;
        getBasicinformationofmaterials(row.materialID).then((response) => {
          this.MaterialListOfTechnology = response.data;
        });
        getProductiontasks(row.productionTasksID).then((response) => {
          this.productiontasks = response.data;
          this.getListProductiontasklist();
          getProductiontasklist(
            this.productiontasks.productionTasksFormID
          ).then((response) => {
            this.productiontasklist = response.data;
            console.log(this.productiontasklist);
            this.loading = false;
          });
        });

        this.open = true;
        this.title = "查看客供入库详细";
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.view_open = false;
      this.reset();
      this.isadd = true;
      this.open = true;
      this.title = "添加客供材料出库详细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.view_open = false;
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getDetailCustomerMaterialOutbound(id).then((response) => {
        this.form = response.data;
        getBasicinformationofmaterials(row.materialID).then((response) => {
          this.MaterialListOfTechnology = response.data;
        });
        getProductiontasks(row.productionTasksID).then((response) => {
          this.productiontasks = response.data;
          this.getListProductiontasklist();
          getProductiontasklist(
            this.productiontasks.productionTasksFormID
          ).then((response) => {
            this.productiontasklist = response.data;
            console.log(this.productiontasklist);
            this.loading = false;
          });
        });

        this.open = true;
        this.title = "修改客供材料出库详细";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (!this.isadd) {
            updateCustomerMaterialsOutbound(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCustomerMaterialsOutbound(this.form).then((response) => {
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
        .confirm('是否确认删除客供材料出库详细编号为"' + ids + '"的数据项？')
        .then(function () {
          return delCustomerMaterialsOutbound(ids);
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
        "storage/DetailCustomerMaterialOutbound/export",
        {
          ...this.queryParams,
        },
        `DetailCustomerMaterialOutbound_${new Date().getTime()}.xlsx`
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
