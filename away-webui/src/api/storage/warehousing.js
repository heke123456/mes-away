import request from '@/utils/request'

// 查询入库单列表
export function listWarehousing(query) {
  return request({
    url: '/system/warehousing/list',
    method: 'get',
    params: query
  })
}

// 查询入库单详细
export function getWarehousing(warehouseEntryID) {
  return request({
    url: '/system/warehousing/' + warehouseEntryID,
    method: 'get'
  })
}

// 新增入库单
export function addWarehousing(data) {
  return request({
    url: '/system/warehousing',
    method: 'post',
    data: data
  })
}

// 修改入库单
export function updateWarehousing(data) {
  return request({
    url: '/system/warehousing',
    method: 'put',
    data: data
  })
}

// 删除入库单
export function delWarehousing(warehouseEntryID) {
  return request({
    url: '/system/warehousing/' + warehouseEntryID,
    method: 'delete'
  })
}
