import request from '@/utils/request'

// 查询DetailsOfToolStorage列表
export function listDetailsOfToolStorage(query) {
  return request({
    url: '/storage/DetailsOfToolStorage/list',
    method: 'get',
    params: query
  })
}

// 查询DetailsOfToolStorage详细
export function getDetailsOfToolStorage(id) {
  return request({
    url: '/storage/DetailsOfToolStorage/' + id,
    method: 'get'
  })
}

// 新增DetailsOfToolStorage
export function addDetailsOfToolStorage(data) {
  return request({
    url: '/storage/DetailsOfToolStorage',
    method: 'post',
    data: data
  })
}

// 修改DetailsOfToolStorage
export function updateDetailsOfToolStorage(data) {
  return request({
    url: '/storage/DetailsOfToolStorage',
    method: 'put',
    data: data
  })
}

// 删除DetailsOfToolStorage
export function delDetailsOfToolStorage(id) {
  return request({
    url: '/storage/DetailsOfToolStorage/' + id,
    method: 'delete'
  })
}
