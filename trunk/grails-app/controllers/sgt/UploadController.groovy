package sgt

class UploadController {

    def upload() {
    def f = request.getFile('myFile')
    if (f.empty) {
        flash.message = 'file cannot be empty'
        render(view: 'uploadForm')
        return
    }

f.transferTo(new File('C:/Users/Guillermo/Desktop/arhivo.txt')) response.sendError(200, 'Done') }
}
