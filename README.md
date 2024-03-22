# Thiết kế và thực thi hai module của hệ thống quản lý rạp chiếu phim từ yêu cầu
Một hệ thống quản lý rạp chiếu phim (CineMan) cho phép nhân viên quản lí, nhân viên bán
hàng và khách hàng sử dụng. Sau khi đăng nhập, các tác nhân có thể thực hiện:
+ Nhân viên quản lí: xem các loại thống kê: phim, khách hàng và doanh thu. Lên lịch
chiếu, quản lí thông tin phim, phòng chiếu (thêm, sửa, xóa).
+ Nhân viên bán hàng: bán vé tại quầy cho khách hàng, xuất thẻ thành viên cho khách
hàng
+ Khách hàng: đăng kí thành viên, tìm kiếm, mua vé trực tuyến, mua vé tại quầy
+ Chức năng khách hàng tìm kiếm thông tin phim: chọn menu tìm thông tin phim →
nhập tên phim để tìm → hệ thống hiện danh sách các phim có tên chứa từ khóa vừa
nhập → click vào một phim xem chi tiết → hệ thống hiện thông tin chi tiết về phim.
+ Chức năng nhân viên lên lịch chiếu: chọn menu quản lí lịch chiếu → chọn thêm lịch
chiếu → chọn khung giờ và ngày chiếu → tìm và chọn phòng chiếu còn rảnh vào khung
giờ đã chọn → chọn phim từ danh sách đang chiếu (thêm mới nếu chưa có) → xác nhận
→ hệ thống báo thành công
  # Công nghệ
  - Java Servelet
  - MySQL
