package bean.repository;

import bean.DBConnection;
import bean.model.ToaNhaTComplex;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.sql.Date.valueOf;

public class ToaNhaRepositoryImpl implements ToaNhaRepository {
    private static final String SELECT_ALL_TOANHA = "select * from toa_nha";
    private static final String SEARCH_TOANHA_THREE ="select * from toa_nha  where `loai_mat_bang` like ? or `tang` =  ? or `gia_tien` = ?;" ;
    private static final String DELETE_TOANHA_BY_ID ="delete from toa_nha where toa_nha_id = ?" ;
    private static final String INSERT_TOANHA_SQL = "INSERT INTO toa_nha" + "  (toa_nha_id,trang_thai,dien_tich,tang,loai_mat_bang,gia_tien,ngay_bat_dau,ngay_bat_dau) VALUES " +
            " (?, ?, ?,?,?, ?, ?,?)";
    private static final String SEARCH_CUSTOMER = "select * from toa_nha   where `loai_mat_bang` like ? and `tang` =  ? and `gia_tien` = ?";


    @Override
    public List<ToaNhaTComplex> selectAllToaNha() {
        List<ToaNhaTComplex> toaNhaTComplexes = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_TOANHA);
                rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String toaNhaId = rs.getString("toa_nha_id");
                    String trangThai = rs.getString("trang_thai");
                    double dienTich = rs.getDouble("dien_tich");
                    int tang = rs.getInt("tang");
                    String loaiMatBang = rs.getString("loai_mat_bang");
                    double giaTien = rs.getDouble("gia_tien");
                    Date ngayBatDau = rs.getDate("ngay_bat_dau");
                    Date ngayKetThuc = rs.getDate("ngay_ket_thuc");


                    ToaNhaTComplex toaNhaTComplex = new ToaNhaTComplex(toaNhaId, trangThai, dienTich, tang, loaiMatBang, giaTien, ngayBatDau, ngayKetThuc);

                    toaNhaTComplexes.add(toaNhaTComplex);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    rs.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return toaNhaTComplexes;
    }

    @Override
    public List<ToaNhaTComplex> searchThreeOne(String search) {
        List<ToaNhaTComplex> toaNhaTComplexes = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_TOANHA_THREE);
            preparedStatement.setString(1,  search );
            preparedStatement.setInt(2, Integer.parseInt(search));
            preparedStatement.setDouble(3, Double.parseDouble(search));

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String toaNhaId = rs.getString("toa_nha_id");
                String trangThai = rs.getString("trang_thai");
                double dienTich = rs.getDouble("dien_tich");
                int tang = rs.getInt("tang");
                String loaiMatBang = rs.getString("loai_mat_bang");
                double giaTien = rs.getDouble("gia_tien");
                Date ngayBatDau = rs.getDate("ngay_bat_dau");
                Date ngayKetThuc = rs.getDate("ngay_ket_thuc");

                ToaNhaTComplex toaNhaTComplex = new ToaNhaTComplex(toaNhaId, trangThai, dienTich, tang, loaiMatBang, giaTien, ngayBatDau, ngayKetThuc);

                toaNhaTComplexes.add(toaNhaTComplex);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return toaNhaTComplexes;
    }

    @Override
    public boolean deleteToaNha(String id) throws SQLException {
        boolean rowDelete = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_TOANHA_BY_ID);
                preparedStatement.setString(1, id);
                rowDelete = preparedStatement.executeUpdate() > 0;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return rowDelete;
    }

    @Override
    public void addCustomer(ToaNhaTComplex toaNhaTComplex) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(INSERT_TOANHA_SQL);
                preparedStatement.setString(1, toaNhaTComplex.getToaNhaId());

                preparedStatement.setString(2, toaNhaTComplex.getTrangThai());
                preparedStatement.setDouble(3, toaNhaTComplex.getDienTich());
                preparedStatement.setInt(4, toaNhaTComplex.getTang());
                preparedStatement.setString(5, toaNhaTComplex.getLoaiMatBang());
                preparedStatement.setDouble(6, toaNhaTComplex.getGiaTien());
                preparedStatement.setDate(7, (java.sql.Date) toaNhaTComplex.getNgayBatDau());
                preparedStatement.setDate(8, (java.sql.Date) toaNhaTComplex.getNgayKetThuc());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public List<ToaNhaTComplex> searchThree(@Nullable String searchName, @Nullable String idCard, @Nullable String searchPhone) {
        List<ToaNhaTComplex> toaNhaTComplexes = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try {
            if (searchName == null) searchName = "";
            if (searchPhone == null) searchPhone = "";
            if (idCard == null) idCard = "";

            searchName = searchName.trim();
            searchPhone = searchPhone.trim();
            idCard = idCard.trim();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER);
            preparedStatement.setString(1, "%" + searchName + "%");
            preparedStatement.setString(2, "%" + idCard + "%");
            preparedStatement.setString(3, "%" + searchPhone + "%");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String toaNhaId = rs.getString("toa_nha_id");
                String trangThai = rs.getString("trang_thai");
                double dienTich = rs.getDouble("dien_tich");
                int tang = rs.getInt("tang");
                String loaiMatBang = rs.getString("loai_mat_bang");
                double giaTien = rs.getDouble("gia_tien");
                Date ngayBatDau = rs.getDate("ngay_bat_dau");
                Date ngayKetThuc = rs.getDate("ngay_ket_thuc");

                ToaNhaTComplex toaNhaTComplex = new ToaNhaTComplex(toaNhaId, trangThai, dienTich, tang, loaiMatBang, giaTien, ngayBatDau, ngayKetThuc);

                toaNhaTComplexes.add(toaNhaTComplex);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return toaNhaTComplexes;
    }
}

