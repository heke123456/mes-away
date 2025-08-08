export default class FileDown {
  constructor(url, file,type,filename) {
    this.url = url;
    this.file = file;
    this.type = type;
    this.filename = filename
    return this.url;
  }
  getFile() {
    return this.file;
  }
  getUrl() {
    return this.url;
  }
  getType(){
    return this.type;
  }
  getFileName(){
    return this.filename;
  }
  fileDown(){
    let a = document.createElement("a");
    a.href = this.url;
    a.target="_blank";
    a.click()
  }

}
