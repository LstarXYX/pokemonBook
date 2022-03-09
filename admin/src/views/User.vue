<template>
  <div>
    <el-table ref="multipleTable"  :data="tableData" style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column  type="selection"  width="55"> </el-table-column>
      <el-table-column prop="name" label="姓名"> </el-table-column>
      <!-- <el-table-column  prop="address"  label="地址"> </el-table-column> -->
    </el-table>
  </div>
</template>

<script>
export default {
  components: {},
  data: function () {
    return {
      tableData: [
        {
          name: "王小虎"
        },
        {
          name: "王小虎"
        },
        {
          name: "王小虎"
        },
        {
          name: "王小虎"
        },
      ],
      multipleSelection: []
    };
  },
  methods: {
      handleSelectionChange(val) {
        this.multipleSelection = val;
      }
  }
};
</script>

<style>
</style>