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
            <el-form-item label="工时名字" prop="manhourName">
              <el-input
                v-model="queryParams.manhourName"
                placeholder="请输入工时名字"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="班别" prop="workClass">
              <el-input
                v-model="queryParams.workClass"
                placeholder="请输入班别"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>
            <el-form-item label="机台号" prop="platformNumber">
              <el-input
                v-model="queryParams.platformNumber"
                placeholder="请输入机台号"
                clearable
                @keyup.enter.native="handleQuery"
              />
            </el-form-item>

            <el-form-item label="批次号" prop="lotNumber">
              <el-input
                v-model="queryParams.lotNumber"
                placeholder="请输入批次号"
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
          v-hasPermi="['produce:detailproductmanhour:add']"
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
          v-hasPermi="['produce:detailproductmanhour:edit']"
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
          v-hasPermi="['produce:detailproductmanhour:remove']"
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
          v-hasPermi="['produce:detailproductmanhour:export']"
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
      :data="detailproductmanhourList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="订单id" align="center" prop="saleorderID" />
      <el-table-column
        label="生产任务id"
        align="center"
        prop="productiontasksID"
      />
      <el-table-column
        label="加工工序"
        align="center"
        prop="processingprocess"
      />
      <el-table-column label="工时名字" align="center" prop="manhourName" />
      <el-table-column label="班别" align="center" prop="workClass" />
      <el-table-column label="机台号" align="center" prop="platformNumber" />
      <el-table-column label="投产数量" align="center" prop="number" />
      <el-table-column
        label="合格数量"
        align="center"
        prop="qualifiedQuantity"
      />
      <el-table-column label="报废数量" align="center" prop="scrapQuantity" />
      <el-table-column label="批次号" align="center" prop="lotNumber" />
      <el-table-column
        label="工时时间"
        align="center"
        prop="manhoursTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.manhoursTime, "{y}-{m}-{d}") }}</span>
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
            v-hasPermi="['produce:detailproductmanhour:query']"
            >查看</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['produce:detailproductmanhour:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['produce:detailproductmanhour:remove']"
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

    <!-- 添加或修改工时统计详细对话框 -->
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
            <el-form-item label="订单id" prop="saleorderID">
              <el-input
                v-model="form.saleorderID"
                disabled
                placeholder="请输入订单id"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="任务单">
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
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="生产任务" prop="productiontasksID">
              <el-select
                filterable
                :disabled="productiontasklist.id == null"
                placeholder="请选择生产任务"
                @focus="
                  getListProductiontasks(productiontasklist.id, saleorderID)
                "
                v-model="form.productiontasksID"
              >
                <el-option
                  v-for="(item, index) in productiontaskslist"
                  :key="index"
                  :label="item.referred"
                  :value="item.id"
                  @click.native="setProductiontasks(item.id)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="生产工艺">
              <el-select
                filterable
                :disabled="productiontasks.id == null"
                v-model="processingtechnology.id"
                @focus="
                  getprocessingtechnologyList(
                    productiontasks.processingTechnologyID
                  )
                "
              >
                <el-option
                  v-for="(item, index) in processingtechnologyList"
                  :key="index"
                  :label="item.id"
                  :value="item.id"
                  @click.native="setprocessingtechnology(item.id)"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="工序" prop="processingprocess">
              <el-select
                filterable
                :disabled="processingtechnology.id == null"
                @focus="getprocessingprocessList(processingtechnology.id)"
                v-model="form.processingprocess"
              >
                <el-option
                  @click.native="setprocessingprocessList(item.id)"
                  v-for="(item, index) in processingprocessList"
                  :key="index"
                  :label="item.id"
                  :value="item.id"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="工时名称" prop="manhourName">
              <el-input
                v-model="form.manhourName"
                placeholder="请输入工时名称"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="班别" prop="workClass">
              <el-input v-model="form.workClass" placeholder="请输入班别" />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="机台号" prop="platformNumber">
              <el-input
                v-model="form.platformNumber"
                placeholder="请输入机台号"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="投产数量" prop="number">
              <el-input
                disabled
                v-model="number"
                placeholder="请输入投产数量"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="合格数量" prop="qualifiedQuantity">
              <el-input
                v-model="form.qualifiedQuantity"
                placeholder="请输入合格数量"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="报废数量" prop="scrapQuantity">
              <el-input
                v-model="form.scrapQuantity"
                placeholder="请输入报废数量"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="批次号" prop="lotNumber">
              <el-input v-model="form.lotNumber" placeholder="请输入批次号" />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="创建时间" prop="manhoursTime">
              <el-date-picker
                clearable
                v-model="form.manhoursTime"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择创建时间"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>

        <el-divider>准备工时</el-divider>
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="制定者名称" prop="formulateName1">
              <el-input
                v-model="form.formulateName1"
                placeholder="请输入制定者名称"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="工序名称" prop="processName1">
              <el-input
                disabled
                v-model="processingprocess.name"
                placeholder="请输入工序名称"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="工艺制定工时" prop="craftdevelopmentHours1">
              <el-input
                disabled
                v-model="processingprocess.preparationHours"
                placeholder="请输入工艺制定工时"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="操作者名称" prop="handlers1">
              <el-input
                v-model="form.handlers1"
                placeholder="请输入操作者名称"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="开始时间" prop="beginTime1">
              <el-date-picker
                v-model="twoTime1"
                type="datetimerange"
                style="margin-left: 3px"
                format="yyyy-MM-dd HH:mm:ss"
                placeholder="请选择开始时间"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>

          <el-col :span="12"> </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="实际时间" prop="actualTime1">
              <el-input
                v-model="form.actualTime1"
                placeholder="请输入实际时间"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <el-divider>实际工时</el-divider>
        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="制定者名称" prop="formulateName2">
              <el-input
                v-model="form.formulateName2"
                placeholder="请输入制定者名称"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="工序名称" prop="processName2">
              <el-input
                disabled
                v-model="processingprocess.name"
                placeholder="请输入工序名称"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="工艺制定工时" prop="craftdevelopmentHours2">
              <el-input
                disabled
                v-model="processingprocess.taktTime"
                placeholder="请输入工艺制定工时"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="操作者名称" prop="handlers2">
              <el-input
                v-model="form.handlers2"
                placeholder="请输入操作者名称"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="开始时间" prop="beginTime1">
              <el-date-picker
                v-model="twoTime2"
                type="datetimerange"
                style="margin-left: 3px"
                format="yyyy-MM-dd HH:mm:ss"
                placeholder="请选择开始时间"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="12">
          <el-col :span="12">
            <el-form-item label="实际时间" prop="actualTime1">
              <el-input
                v-model="form.actualTime2"
                placeholder="请输入实际时间"
              />
            </el-form-item>
          </el-col>

          <el-col :span="12"> </el-col>
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
  listSaleorder,
  getSaleorder,
  delSaleorder,
  addSaleorder,
  updateSaleorder,
} from "@/api/order/saleorder";

import {
  listDetailproductmanhour,
  getDetailproductmanhour,
  delDetailproductmanhour,
  addDetailproductmanhour,
  updateDetailproductmanhour,
} from "@/api/produce/detailproductmanhour";
import {
  listProductmanhour,
  getProductmanhour,
  delProductmanhour,
  addProductmanhour,
  updateProductmanhour,
} from "@/api/produce/productmanhour";

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
  listProcessingprocess,
  getProcessingprocess,
} from "@/api/produce/processingprocess";
export default {
  name: "Detailproductmanhour",
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
      // 工时统计详细表格数据
      detailproductmanhourList: [],
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
        saleorderID: null,
        productiontasksID: null,
        processingprocess: null,
        manhourName: null,
        workClass: null,
        platformNumber: null,
        number: null,
        qualifiedQuantity: null,
        scrapQuantity: null,
        lotNumber: null,
        manhoursTime: null,
        formulateName1: null,
        handlers1: null,
        beginTime1: null,
        endTime1: null,
        actualTime1: null,
        formulateName2: null,
        handlers2: null,
        beginTime2: null,
        endTime2: null,
        actualTime2: null,
        number: null,
        name: null,
        preparationHours: null,
        taktTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [{ required: true, message: "工时id不能为空", trigger: "blur" }],
        saleorderID: [
          { required: true, message: "订单id不能为空", trigger: "blur" },
        ],
        preparationHours: [
          { required: true, message: "准备工时不能为空", trigger: "blur" },
        ],
        taktTime: [
          { required: true, message: "单件工时不能为空", trigger: "blur" },
        ],
      },

      saleorder: {},
      number: "",
      //订单id
      saleorderID: "",
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
      //工序列表
      processingprocessList: [],
      //当前选中的工艺
      processingprocess: {},
      twoTime1: [],
      twoTime2: [],
    };
  },
  created() {
    this.getExist();
  },
  methods: {
    getExist() {
      this.saleorderID = this.$route.query.id;
      this.number = this.$route.query.number;

      this.queryParams.saleorderID = this.$route.query.id;
      this.getList();
    },

    /** 查询生产工时列表 */
    getList() {
      this.loading = true;
      listDetailproductmanhour(this.queryParams).then((response) => {
        this.detailproductmanhourList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },

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
    async getListProductiontasks(productionTasksFormID, saleorderID) {
      this.loading = true;
      let total = (await listProductiontasks())["total"];
      listProductiontasks({
        productionTasksFormID: productionTasksFormID,
        saleOrderID: saleorderID,
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

    async getprocessingprocessList(id) {
      this.loading = true;
      let total = (await listProcessingprocess())["total"];

      listProcessingprocess({
        processingTechnologyID: id,
        pageSize: total,
      }).then((response) => {
        this.processingprocessList = response.rows;
        this.loading = false;
      });
    },

    //选择生产工序
    setprocessingprocessList(id) {
      this.loading = true;
      getProcessingprocess(id).then((response) => {
        this.processingprocess = response.data;
        this.loading = false;
      });
    },

    //计算时间
    getTim(twoTime) {
      const diff = twoTime[1] - twoTime[0];
      //一天毫秒数
      const dayUnit = 60 * 60 * 24 * 1000;
      let stayDay = Math.floor(diff / dayUnit);
      let modHour = diff % (24 * 1000 * 3600); //模一天毫秒数，刚刚拿到一天升序的小时
      let stayHour = Math.floor(modHour / (3600 * 1000));
      let modMin = modHour % (3600 * 1000);
      let stayMin = Math.floor(modMin / (60 * 1000));
      let modSec = modMin % (60 * 1000);
      let staySec = Math.floor(modSec / 1000);
      return `工时${stayDay}天${stayHour}小时${stayMin}分${staySec}秒`;
    },

    setTime() {
      if (this.form.actualTime1 == null) {
        //计算时间
        this.form.actualTime1 = this.getTim(this.twoTime1);
      }
      if (this.form.actualTime2 == null) {
        //计算时间

        this.form.actualTime2 = this.getTim(this.twoTime2);
      }
      console.log(this.twoTime2);

      if (this.twoTime1.length != 0) {
        this.form.beginTime1 = this.parseTime(this.twoTime1[0]);
        this.form.endTime1 = this.parseTime(this.twoTime1[1]);
        this.form.actualTime1 = this.getTim(this.twoTime1);
      }

      if (this.twoTime2.length != 0) {
        this.form.beginTime2 = this.parseTime(this.twoTime2[0]);
        this.form.endTime2 = this.parseTime(this.twoTime2[1]);
        this.form.actualTime2 = this.getTim(this.twoTime2);
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
        saleorderID: this.saleorderID,
        productiontasksID: null,
        processingprocess: null,
        manhourName: null,
        workClass: null,
        platformNumber: null,
        qualifiedQuantity: null,
        scrapQuantity: null,
        lotNumber: null,
        manhoursTime: null,
        formulateName1: null,
        handlers1: null,
        beginTime1: null,
        endTime1: null,
        actualTime1: null,
        formulateName2: null,
        processName2: null,
        craftdevelopmentHours2: null,
        handlers2: null,
        beginTime2: null,
        endTime2: null,
        actualTime2: null,
      };

      (this.saleorder = {}),
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
        //工序列表
        (this.processingprocessList = []),
        //当前选中的工艺
        (this.processingprocess = {}),
        this.resetForm("form");
      this.twoTime1 = [];
      this.twoTime2 = [];

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
      getProductmanhour(id).then((response) => {
        this.form = response.data;
        //订单回显
        getSaleorder(row.saleorderID).then((response) => {
          this.number = response.data.number;
        });
        //生产工艺下拉框回显
        getProcessingprocess(this.form.processingprocess).then((response) => {
          this.processingprocess = response.data;

          listProcessingtechnology({
            id: this.processingprocess.processingTechnologyID,
          }).then((response) => {
            this.processingtechnology = response.rows[0];
          });
        });

        //任务回显
        getProductiontasks(this.form.productiontasksID).then((response) => {
          this.productiontasks = response.data;

          this.getListProductiontasklist();
          listProductiontasklist({
            id: this.productiontasks.productionTasksFormID,
          }).then((response) => {
            this.productiontasklist = response.rows[0];
          });
        });

        if (
          response.data.beginTime1 != null &&
          response.data.endTime1 != null
        ) {
          const time1 = new Date(response.data.beginTime1);
          const time2 = new Date(response.data.endTime1);
          this.twoTime1 = [time1, time2];
        }

        if (
          response.data.beginTime2 != null &&
          response.data.endTime2 != null
        ) {
          const time3 = new Date(response.data.beginTime2);
          const time4 = new Date(response.data.endTime2);
          this.twoTime2 = [time3, time4];
        }

        this.view_open = true;
        this.open = true;
        this.title = "查看生产工时详细";
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.isadd = true;
      this.open = true;
      this.view_open = false;
      this.title = "添加工时统计详细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.isadd = false;
      const id = row.id || this.ids;
      getProductmanhour(id).then((response) => {
        this.form = response.data;
        //订单回显
        getSaleorder(row.saleorderID).then((response) => {
          this.number = response.data.number;
        });
        //生产工艺下拉框回显
        getProcessingprocess(this.form.processingprocess).then((response) => {
          this.processingprocess = response.data;

          listProcessingtechnology({
            id: this.processingprocess.processingTechnologyID,
          }).then((response) => {
            this.processingtechnology = response.rows[0];
          });
        });

        //任务回显
        getProductiontasks(this.form.productiontasksID).then((response) => {
          this.productiontasks = response.data;

          this.getListProductiontasklist();
          listProductiontasklist({
            id: this.productiontasks.productionTasksFormID,
          }).then((response) => {
            this.productiontasklist = response.rows[0];
          });
        });

        if (
          response.data.beginTime1 != null &&
          response.data.endTime1 != null
        ) {
          const time1 = new Date(response.data.beginTime1);
          const time2 = new Date(response.data.endTime1);
          this.twoTime1 = [time1, time2];
        }

        if (
          response.data.beginTime2 != null &&
          response.data.endTime2 != null
        ) {
          const time3 = new Date(response.data.beginTime2);
          const time4 = new Date(response.data.endTime2);
          this.twoTime2 = [time3, time4];
        }

        this.view_open = false;
        this.open = true;
        this.title = "修改生产工时详细";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        this.setTime();
        if (valid) {
          if (!this.isadd) {
            updateProductmanhour(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProductmanhour(this.form).then((response) => {
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
        .confirm('是否确认删除工时统计详细编号为"' + ids + '"的数据项？')
        .then(function () {
          return delProductmanhour(ids);
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
        "produce/detailproductmanhour/export",
        {
          ...this.queryParams,
        },
        `detailproductmanhour_${new Date().getTime()}.xlsx`
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
  },
};
</script>
