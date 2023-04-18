public ArrayList<NhanVien> getItems() {
   ArrayList<NhanVien> nhanViens = new ArrayList<>();
   conn = DBConnectionUtil.getConnection();
   String query = "SELECT * , nhanvien.id AS nvid FROM nhanvien "
         + "INNER JOIN taikhoan "
         + "ON nhanvien.id_taikhoan = taikhoan.id "
         + "INNER JOIN luongcb "
         + "ON nhanvien.id_luongcb = luongcb.id;";
   try {
      st = conn.createStatement();
      rs = st.executeQuery(query);
      while(rs.next()){
         int id = rs.getInt("nvid");
         String gioitinh = rs.getString("gioitinh");
         String address = rs.getString("address");
         TaiKhoan taiKhoan = new TaiKhoan(rs.getInt("id_taikhoan"), rs.getString("username"), rs.getString("password"), rs.getString("fullname"), rs.getString("picture"), rs.getString("position"));
         LuongCB luongCB = new LuongCB(rs.getInt("id_luongcb"), rs.getString("job"), rs.getInt("money"));
         NhanVien item = new NhanVien(id, gioitinh, address, luongCB, taiKhoan);
         nhanViens.add(item);
      }
   } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
   } finally{
      if(rs != null && st != null && conn != null){
         try {
            rs.close();
            st.close();
            conn.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }
   return nhanViens;