import request from '@/utils/request'

// 查询材料入库详细列表
export function listMaterialWarehousingDetailed(query) {
  return request({
    url: '/storage/materialWarehousingDetailed/list',
    method: 'get',
    params: query
  })
}

// 查询材料入库详细详细
export function getMaterialWarehousingDetailed(warehouseEntryID) {
  return request({
    url: '/storage/materialWarehousingDetailed/' + warehouseEntryID,
    method: 'get'
  })
}

// 新增材料入库详细
export function addMaterialWarehousingDetailed(data) {
  return request({
    url: '/storage/materialWarehousingDetailed',
    method: 'post',
    data: data
  })
}

// 修改材料入库详细
export function updateMaterialWarehousingDetailed(data) {
  return request({
    url: '/storage/materialWarehousingDetailed',
    method: 'put',
    data: data
  })
}

// 删除材料入库详细
export function delMaterialWarehousingDetailed(warehouseEntryID) {
  return request({
    url: '/storage/materialWarehousingDetailed/' + warehouseEntryID,
    method: 'delete'
  })
}
