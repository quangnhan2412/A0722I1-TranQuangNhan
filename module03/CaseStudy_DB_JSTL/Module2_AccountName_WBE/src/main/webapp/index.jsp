<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" href="BootStrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="BootStrap/bootstrap-5.3.0-alpha1-dist/css/">
    <link rel="stylesheet" href="CSS_HomePage/Home_Page.css">
</head>
<body>
<div class="header">
    <div class="row bg-light">

        <div class="col-3">
            <a href="/" class="header_logo">
                <img src="CSS_HomePage/img/Logo_furama.jpg" class="img-fluid" alt="logo" width="30%" height="100%">
            </a>
        </div>
        <div class="col-6 ">
            <h1>Wishing you good health<span class="badge bg-secondary">Welcome to the page Furama</span></h1>
        </div>
        <div class="col-3" id="nhan">
            <h4>Trần Quang Nhân</h4>
        </div>
    </div>
</div>
<div class="navigation text-center bg-info">
    <div class="row ">
        <div class="col-2"></div>
        <div class="col-1">
            <a class="btn btn-primary" href="#" role="button">Home</a>
        </div>
        <div class="col-1">
            <a class="btn btn-primary" href="#" role="button">Employee</a>
        </div>
        <div class="col-1">
            <a class="btn btn-primary" href="customers?action=customer" role="button">Customer</a>
        </div>
        <div class="col-1">
            <a class="btn btn-primary" href="#" role="button">Service</a>
        </div>
        <div class="col-1">
            <a class="btn btn-primary" href="#" role="button">Contract</a>
        </div>
        <div class="col-5">
            <div class="row">
            <div class="input-group">
                <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                <button type="button" class="btn btn-primary">search</button>
            </div>
            </div>
        </div>
    </div>
</div>
<div class="content">
    <div class="row">
        <div class="col-2">
            <div id="list-example" class="list-group">
                <a class="list-group-item list-group-item-action" href="#list-item-1">Sổ tay nhân viên khách sạn là gì? </a>
                <a class="list-group-item list-group-item-action" href="#list-item-2">Customer service cung cấp thông tin về trải nghiệm khách hàng</a>
                <a class="list-group-item list-group-item-action" href="#list-item-3">Customer service là bộ mặt, hình ảnh của công ty</a>
                <a class="list-group-item list-group-item-action" href="#list-item-4">Dịch vụ khách hàng tốt nâng cao lòng trung thành của khách hàng</a>
            </div>
        </div>
        <div class="col-10">
            <div data-bs-spy="scroll" data-bs-target="#list-example" data-bs-smooth-scroll="true" class="scrollspy-example" tabindex="0">
                <h4 id="list-item-1">Sổ tay nhân viên khách sạn là gì? </h4>
                <p>Sổ tay nhân viên khách sạn là một tài liệu do khách sạn biên soạn.
                    Nội dung bên trong khái quát về khách sạn, tuyên ngôn và nhiệm vụ của khách sạn. Quyển sổ tay này mô tả nội quy làm việc, trách nhiệm và
                    quyền lợi, khen thưởng, kỷ luật và những tiêu chuẩn nhân viên phải tuân thủ khi trở thành thành viên của đội ngũ nhân sự khách sạn.
                    Mục tiêu khi xây dựng sổ tay nhân viên là để giới thiệu cho nhân viên những thông tin cần thiết về khách sạn, giúp họ thấy được sứ mệnh phát triển
                    của khách sạn, từ đó họ sẽ hiểu được cần phải làm gì và không nên làm gì vì mục tiêu chung khách sạn</p>
                <h4 id="list-item-2">Item 2</h4>
                <p>.Trong quá trình thực hiện công việc customer service, các chuyên viên sẽ hiểu rõ những mong muốn và nỗi trăn trở của khách hàng. Hơn thế, bộ phận
                    customer service là nơi tiếp nhận những phản hồi, lời phàn nàn của khách hàng về trải nghiệm chưa tốt.
                    Khi lắng nghe những điều đó, các chuyên viên sẽ hiểu rõ về vấn đề của sản phẩm, dịch vụ. Từ đó mang những thông tin về trải nghiệm khách hàng
                    đến các đội ngũ liên quan. Bằng cách này, những bộ phận ấy có thể tìm cách giải quyết vấn đề tối ưu hơn nhằm mang đến trải nghiệm hoàn hảo hơn.</p>
                <h4 id="list-item-3">Customer service là bộ mặt, hình ảnh của công ty</h4>
                <p>Một đội ngũ customer service chỉn chu, chuyên nghiệp sẽ gây ấn tượng tốt đẹp trong mắt khách hàng. Họ sẽ tiếp tục quay trở lại mua sắm và trải nghiệm sản phẩm, dịch vụ của doanh nghiệp. Từ đó, hình ảnh thương hiệu sẽ được cải thiện và tích cực hơn rất nhiều.
                    Ngược lại, một đội customer service kém cỏi sẽ gây bất mãn nơi khách hàng. Họ sẽ không muốn tiếp tục trải nghiệm sản phẩm, dịch vụ dù chúng tốt đến mấy. Không chỉ vậy, “tiếng lành đồn xa, tiếng dữ đồn xa hơn”. Họ sẽ truyền miệng (word of mouth) để bạn bè, người thân của họ “né” dùng sản phẩm của bạn đấy!</p>
                <h4 id="list-item-4">Dịch vụ khách hàng tốt nâng cao lòng trung thành của khách hàng</h4>
                <p>Theo thống kê của công ty Bain & Company, chỉ cần tăng 5% mức tỷ lệ giữ chân khách hàng, lợi nhuận có thể tăng thêm 25%. Khách hàng trung thành sẽ có xu hướng chi nhiều tiền bạc hơn cho thương hiệu của bạn. Điều này đồng nghĩa với việc bạn không cần phải chi quá nhiều tiền cho các hoạt động Marketing, quảng cáo,…
                    Có thể nói, customer service phần lớn sẽ giúp giữ chân khách hàng để biến họ từ khách hãng lai thành khách hàng thân thiết. Bởi lẽ trong thị trường hiện tại, các sản phẩm đôi khi không quá khác biệt. Thế nên, trải nghiệm khách hàng tích cực trở thành lợi thế cạnh tranh vượt trội.</p>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <!-- Footer -->
    <footer class="text-center text-lg-start bg-light text-muted">
        <!-- Section: Social media -->
        <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
            <!-- Left -->
            <div class="me-5 d-none d-lg-block">
                <span>Get connected with us on social networks:</span>
            </div>
            <!-- Left -->

            <!-- Right -->
            <div>
                <a href="" class="me-4 text-reset">
                    <i class="fab fa-facebook-f"></i>
                </a>
                <a href="" class="me-4 text-reset">
                    <i class="fab fa-twitter"></i>
                </a>
                <a href="" class="me-4 text-reset">
                    <i class="fab fa-google"></i>
                </a>
                <a href="" class="me-4 text-reset">
                    <i class="fab fa-instagram"></i>
                </a>
                <a href="" class="me-4 text-reset">
                    <i class="fab fa-linkedin"></i>
                </a>
                <a href="" class="me-4 text-reset">
                    <i class="fab fa-github"></i>
                </a>
            </div>
            <!-- Right -->
        </section>
        <!-- Section: Social media -->
        <!-- Section: Links  -->
        <section class="">
            <div class="container text-center text-md-start mt-5">
                <!-- Grid row -->
                <div class="row mt-3">
                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                        <!-- Content -->
                        <h6 class="text-uppercase fw-bold mb-4">
                            <i class="fas fa-gem me-3"></i>Company name
                        </h6>
                        <p>
                            Here you can use rows and columns to organize your footer content. Lorem ipsum
                            dolor sit amet, consectetur adipisicing elit.
                        </p>
                    </div>
                    <!-- Grid column -->
                    <!-- Grid column -->
                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4">
                            Products
                        </h6>
                        <p>
                            <a href="#!" class="text-reset">Angular</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">React</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Vue</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Laravel</a>
                        </p>
                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4">
                            Useful links
                        </h6>
                        <p>
                            <a href="#!" class="text-reset">Pricing</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Settings</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Orders</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Help</a>
                        </p>
                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
                        <p><i class="fas fa-home me-3"></i> New York, NY 10012, US</p>
                        <p>
                            <i class="fas fa-envelope me-3"></i>
                            info@example.com
                        </p>
                        <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
                        <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
                    </div>
                    <!-- Grid column -->
                </div>
                <!-- Grid row -->
            </div>
        </section>
        <!-- Section: Links  -->

        <!-- Copyright -->
        <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
            © 2023 FaceBook:
            <a class="text-reset fw-bold" href="https://www.facebook.com/quangnhan2412/">fb:Trần Quang Nhân</a>
        </div>
        <!-- Copyright -->
    </footer>
    <!-- Footer -->
</div>
</body>

<script src="BootStrap/bootstrap-5.3.0-alpha1-dist/js/bootstrap.bundle.min.js"></script>
<script src="BootStrap/bootstrap-5.3.0-alpha1-dist/js/bootstrap.js"></script>
</html>