import request from '@/utils/request'
import FileDown from './FileDown'

// 上传文件
export function fileUpdate(query) {
  return request({
    url: '/awise/file/update',
    method: 'post',
    data: query
  })
}
// 下载文件
export async function fileDownload(query,responseType="blob") {

  let response = await request({
    url: '/awise/file/download/' + query,
    method: 'get',
    responseType: responseType

  })


  let blob = response
  let type = blob["type"]
  let file = new File([blob],query)
  let tmp_url = window.URL.createObjectURL(blob)
  let file_down = new FileDown(tmp_url,file,type,query);
  return file_down;

}

// 删除文件
export function fileDelete(query) {
  return request({
    url: '/awise/file/delete',
    method: 'get',
    params: query
  })
}



