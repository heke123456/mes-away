import request from '@/utils/request'

// 查询本地材料入库列表
export function listLocalmaterialwarehousing(query) {
  return request({
    url: '/storage/localmaterialwarehousing/list',
    method: 'get',
    params: query
  })
}

// 查询本地材料入库详细
export function getLocalmaterialwarehousing(id) {
  return request({
    url: '/storage/localmaterialwarehousing/' + id,
    method: 'get'
  })
}

// 新增本地材料入库
export function addLocalmaterialwarehousing(data) {
  return request({
    url: '/storage/localmaterialwarehousing',
    method: 'post',
    data: data
  })
}

// 修改本地材料入库
export function updateLocalmaterialwarehousing(data) {
  return request({
    url: '/storage/localmaterialwarehousing',
    method: 'put',
    data: data
  })
}

// 删除本地材料入库
export function delLocalmaterialwarehousing(id) {
  return request({
    url: '/storage/localmaterialwarehousing/' + id,
    method: 'delete'
  })
}
