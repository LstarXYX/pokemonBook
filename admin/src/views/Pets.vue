<template>
    <div> 
        <el-button type="primary" icon="el-icon-edit">添加</el-button>
        <el-divider></el-divider>
        <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column  prop="name" label="精灵名字" width="180"> </el-table-column>
      <el-table-column  prop="no"  label="编号"  width="180"> </el-table-column>
      <el-table-column  label="图片"> 
            <template slot-scope="scope">
                <el-image 
                    style="width: 100px; height: 100px"
                    :src="scope.row.image_url" 
                 > </el-image>
            </template>
      </el-table-column>
       <el-table-column  label="属性一">
            <template slot-scope="scope">
                <el-avatar icon="el-icon-user-solid">
                    {{scope.row.attr_one}}    
                </el-avatar>    
            </template>   
        </el-table-column>

        <el-table-column  label="属性二">
            <template slot-scope="scope">
                <el-avatar icon="el-icon-user-solid">
                    {{scope.row.attr_two}}    
                </el-avatar>    
            </template>
        </el-table-column>
    </el-table>
    <el-pagination
        class="page_helper"
        background
        layout="prev, pager, next"
        :total="pager.total"
        :page-count="pager.page_count"
        :current-page="pager.current_page"
        :page-size="pager.page_size"
        >
    </el-pagination>
    </div>
</template>

<script>

export default {
    components: {

    },
    data: function() {
        return {
            tableData: [ 
                {
                  name: '精灵名字',
                  no: '精灵编号',
                  image_url: '',
                  attr_one: 0,
                  attr_two: 1
              },
              {
                  name: '精灵名字2',
                  no: '精灵编号2',
                  image_url: '',
                  attr_one: 1,
                  attr_two: 1
              },
              {
                  name: '精灵名字3',
                  no: '精灵编号3',
                  image_url: '',
                  attr_one: 2,
                  attr_two: 1
              }
          ],
          pager: {
              total: 1000,
              page_count: 100, //总页数
              current_page: 1,  //当前页数
              page_size: 2
          }
        }
    }
}
</script>

<style>
.page_helper{
    width: 30%;
    padding-left: 35%;
}
</style>