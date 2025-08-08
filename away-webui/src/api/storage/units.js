import request from '@/utils/request'

// 查询计量单位存储计量单位用于供所有确定计量单位存储   计量单位列表
export function listUnits(query) {
  return request({
    url: '/storage/units/list',
    method: 'get',
    params: query
  })
}

// 查询计量单位存储计量单位用于供所有确定计量单位存储   计量单位详细
export function getUnits(id) {
  return request({
    url: '/storage/units/' + id,
    method: 'get'
  })
}

// 新增计量单位存储计量单位用于供所有确定计量单位存储   计量单位
export function addUnits(data) {
  return request({
    url: '/storage/units',
    method: 'post',
    data: data
  })
}

// 修改计量单位存储计量单位用于供所有确定计量单位存储   计量单位
export function updateUnits(data) {
  return request({
    url: '/storage/units',
    method: 'put',
    data: data
  })
}

// 删除计量单位存储计量单位用于供所有确定计量单位存储   计量单位
export function delUnits(id) {
  return request({
    url: '/storage/units/' + id,
    method: 'delete'
  })
}
