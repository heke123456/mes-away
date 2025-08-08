import request from '@/utils/request'

// 查询城市存储   省，市，县区列表
export function listCity(query) {
  return request({
    url: '/city/city/list',
    method: 'get',
    params: query
  })
}

// 查询城市存储Json
export function jsonCity(query) {
  return request({
    url: '/city/city/json',
    method: 'get',
    params: query
  })
}

// 查询城市存储   省，市，县区详细
export function getCity(id) {
  return request({
    url: '/city/city/' + id,
    method: 'get'
  })
}

// 新增城市存储   省，市，县区
export function addCity(data) {
  return request({
    url: '/city/city',
    method: 'post',
    data: data
  })
}

// 修改城市存储   省，市，县区
export function updateCity(data) {
  return request({
    url: '/city/city',
    method: 'put',
    data: data
  })
}

// 删除城市存储   省，市，县区
export function delCity(id) {
  return request({
    url: '/city/city/' + id,
    method: 'delete'
  })
}
