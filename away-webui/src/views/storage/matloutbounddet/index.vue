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
            <el-form-item label="任务编号" prop="productionTasksID">
              <el-input
                v-model="queryParams.productionTasksID"
                placeholder="请输入任务编号"
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
          v-hasPermi="['storage:matloutbounddet:add']"
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
          v-hasPermi="['storage:matloutbounddet:edit']"
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
          v-hasPermi="['storage:matloutbounddet:remove']"
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
          v-hasPermi="['storage:matloutbounddet:export']"
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
      :data="matloutbounddetList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        label="出库单编号"
        align="center"
        prop="deliveryNoteID"
      />
      <el-table-column label="材料信息编号" align="center" prop="materialID" />
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
            v-hasPermi="['storage:matloutbounddet:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-if="upper_status == '0'"
            v-hasPermi="['storage:matloutbounddet:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-if="upper_status == '0'"
            v-hasPermi="['storage:matloutbounddet:remove']"
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

    <!-- 添加或修改材料出库详细对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form
        :disabled="view_open"
        ref="matloutbounddet"
        :model="matloutbounddet"
        :rules="rules"
        label-width="80px"
      >
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="出库单编号" prop="deliveryNoteID">
              <el-input
                disabled
                v-model="matloutbounddet.deliveryNoteID"
                placeholder="请输入出库单编号"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="出库数量" prop="outboundQuantity">
              <el-input
                type="Number"
                v-model="matloutbounddet.outboundQuantity"
                placeholder="请输入出库数量"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="任务单" prop="productionTasksID">
              <el-select
                filterable
                v-model="productiontasklist.id"
                placeholder="请选择任务单"
                @focus="getListProductiontasklist()"
              >
                <el-option
                  v-for="(item, index) in productiontasklistlist"
                  :key="index"
                  :label="item.referred"
                  :value="item.id"
                  @click.native="setProductiontasklist(item.id)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="任务编号" prop="productionTasksID">
              <el-select
                filterable
                :disabled="productiontasklist.id == null"
                v-model="matloutbounddet.productionTasksID"
                placeholder="请选择任务编号"
                @focus="getListProductiontasks(productiontasklist.id)"
              >
                <el-option
                  v-for="(item, index) in productiontaskslist"
                  :key="index"
                  :label="item.id"
                  :value="item.id"
                  @click.native="setProductiontasks(item.id)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="工艺编号" prop="processingTechnologyID">
              <el-select
                filterable
                v-model="matloutbounddet.processingTechnologyID"
                placeholder="请选择工艺编号"
                @focus="getListProcessingTechnologys()"
              >
                <el-option
                  v-for="(item, index) in Processingtechnology"
                  :key="index"
                  :label="item.id"
                  :value="item.id"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="材料信息编号" prop="materialID">
              <el-select
                filterable
                :disabled="matloutbounddet.processingTechnologyID == null"
                v-model="matloutbounddet.materialID"
                placeholder="请选择材料信息编号"
                @focus="
                  getListMateriallistoftechnology(
                    matloutbounddet.processingTechnologyID
                  )
                "
              >
                <el-option
                  v-for="(item, index) in materiallistoftechnologylist"
                  :key="index"
                  :label="item.materialID"
                  :value="item.materialID"
                  @click.native="setMateriallistoftechnology(item.id)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="材料名称" prop="name">
              <el-input
                disabled
                v-model="matloutbounddet.name"
                placeholder="请输入材料名称"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="类别名称" prop="typeName">
              <el-input
                disabled
                v-model="matloutbounddet.typeName"
                placeholder="请输入类别名称"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="规格型号" prop="specificationModel">
              <el-input
                disabled
                v-model="matloutbounddet.specificationModel"
                placeholder="请输入规格型号"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="备注" prop="notes">
              <el-input
                v-model="matloutbounddet.notes"
                placeholder="请输入备注"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="材料价格" prop="specificationModel">
              <el-input
                disabled
                v-model="matloutbounddet.materialPrice"
                placeholder="请输入材料价格"
              />
            </el-form-item>
          </el-col>
        </el-row>
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
  listMatloutbounddet,
  getMatloutbounddet,
} from "@/api/storage/matloutbounddet";
import {
  addLocalmaterialoutbound,
  updateLocalmaterialoutbound,
  delLocalmaterialoutbound,
} from "@/api/storage/localmaterialoutbound.js";
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
import { setIntersectionObj } from "@/utils/utils.js";

export default {
  name: "Matloutbounddet",
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
      // 材料出库详细表格数据
      matloutbounddetList: [],
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
        name: null,
        typeName: null,
        specificationsType: null,
        specificationModel: null,
        productionTasksID: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        deliveryNoteID: [
          { required: true, message: "出库单编号不能为空", trigger: "blur" },
        ],
        materialID: [
          { required: true, message: "材料信息编号不能为空", trigger: "blur" },
        ],
        name: [
          { required: true, message: "材料名称不能为空", trigger: "blur" },
        ],
        outboundQuantity: [
          { required: true, message: "出库数量不能为空", trigger: "blur" },
        ],
      },
      // 当前出库单编号
      deliveryNoteID: null,
      // 当前选中材料出库详细
      matloutbounddet: {},
      // 父单状态
      upper_status: null,

      // 任务单列表
      productiontasklistlist: [],
      // 当前选中任务单
      productiontasklist: {},
      // 任务列表
      productiontaskslist: [],
      // 当前选中任务
      productiontasks: {},
      //加工工艺
      processingtechnology: [],
      // 工艺所需材料列表
      materiallistoftechnologylist: [],
      // 当前所选工艺所需材料
      materiallistoftechnology: {},
    };
  },
  created() {
    this.getExist();
  },
  methods: {
    getExist() {
      this.deliveryNoteID = this.$route.query.id;
      this.queryParams.deliveryNoteID = this.deliveryNoteID;
      this.upper_status = this.$route.query.status;
      this.getList();
    },
    /** 查询材料出库详细列表 */
    getList() {
      this.loading = true;

      listMatloutbounddet(this.queryParams).then((response) => {
        this.matloutbounddetList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询任务单列表 */
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

    async getListProcessingTechnologys() {
      this.loading = true;
      let total = (await listProcessingtechnology())["total"];

      listProcessingtechnology({ pageSize: total }).then((response) => {
        this.Processingtechnology = response.rows;
        this.loading = false;
      });
    },
    /** 查询工艺所需材料列表 */
    async getListMateriallistoftechnology(processingTechnologyID) {
      this.loading = true;
      let total = (await listMaterialListOfTechnology())["total"];
      listMaterialListOfTechnology({
        processingTechnologyID: processingTechnologyID,
        pageSize: total,
      }).then((response) => {
        this.materiallistoftechnologylist = response.rows;
        this.loading = false;
      });
    },
    /** 选中当前所选工艺所需材料 */
    setMateriallistoftechnology(id) {
      this.loading = true;
      getMaterialListOfTechnology(id).then((response) => {
        this.materiallistoftechnology = response.data;
        let tmpObj = {
          name: null,
          materialPrice: null,
          typeName: null,
          specificationsType: null,
          specificationModel: null,
        };
        setIntersectionObj(tmpObj, this.materiallistoftechnology);
        setIntersectionObj(this.matloutbounddet, tmpObj);
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
      this.matloutbounddet = {
        id: null,
        deliveryNoteID: this.deliveryNoteID,
        materialID: null,
        materialPrice: null,
        name: null,
        typeName: null,
        specificationsType: null,
        specificationModel: null,
        productionTasksID: null,
        processingTechnologyID: null,
        outboundQuantity: null,
        notes: null,
      };
      this.form = {
        id: null,
        deliveryNoteID: null,
        materialID: null,
        productionTasksID: null,
        processingTechnologyID: null,
        outboundQuantity: null,
        notes: null,
      };
      // 任务单列表
      this.productiontasklistlist = [];
      // 当前选中任务单
      this.productiontasklist = {};
      // 任务列表
      this.productiontaskslist = [];
      // 当前选中任务
      this.productiontasks = {};
      // 工艺所需材料列表
      this.materiallistoftechnologylist = [];
      // 当前所选工艺所需材料
      this.materiallistoftechnology = {};
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
      getMatloutbounddet(id).then((response) => {
        this.matloutbounddet = response.data;
        this.view_open = true;
        getProductiontasks(row.productionTasksID).then((response) => {
          let productionTasksFormID = response.data.productionTasksFormID;

          this.getListProductiontasklist();

          getProductiontasklist(productionTasksFormID).then((response) => {
            this.productiontasklist = response.data;
            this.loading = false;
          });
        });
        this.open = true;
        this.title = "材料出库详细";
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.view_open = false;
      this.open = true;
      this.title = "添加材料出库详细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getMatloutbounddet(id).then((response) => {
        this.matloutbounddet = response.data;
        this.view_open = false;
        getProductiontasks(row.productionTasksID).then((response) => {
          let productionTasksFormID = response.data.productionTasksFormID;
          this.getListProductiontasklist();
          getProductiontasklist(productionTasksFormID).then((response) => {
            this.productiontasklist = response.data;
            this.loading = false;
          });
        });
        this.open = true;
        this.title = "修改材料出库";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["matloutbounddet"].validate((valid) => {
        if (valid) {
          setIntersectionObj(this.form, this.matloutbounddet);
          console.log(this.form);
          if (!this.isadd) {
            updateLocalmaterialoutbound(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLocalmaterialoutbound(this.form).then((response) => {
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
        .confirm('是否确认删除材料出库详细编号为"' + ids + '"的数据项？')
        .then(function () {
          return delLocalmaterialoutbound(ids);
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
        "storage/matloutbounddet/export",
        {
          ...this.queryParams,
        },
        `matloutbounddet_${new Date().getTime()}.xlsx`
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
