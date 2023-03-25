
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="footer">
    <!-- Footer -->

    <footer class="bg-success text-center text-white">
        <!-- Grid container -->
        <div class="container p-4">
            <!-- Section: Social media -->
            <section class="mb-4">
                <!-- Facebook -->
                <a class="btn btn-outline-light btn-floating m-1" href="https://www.facebook.com/QuizGym-102791849085267" target="_blank" role="button"
                ><i class="fab fa-facebook-f"></i
                ></a>

                <!-- Twitter -->
                <a class="btn btn-outline-light btn-floating m-1" href="#https://twitter.com/Quiz_Gym" target="_blank" role="button"
                ><i class="fab fa-twitter"></i
                ></a>

                <!-- Google -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-google"></i
                ></a>

                <!-- Instagram -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-instagram"></i
                ></a>

                <!-- Linkedin -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-linkedin-in"></i
                ></a>

                <!-- Github -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-github"></i
                ></a>
            </section>
            <!-- Section: Social media -->
            <!-- Section: Links -->
            <section class="">
                <!-- Grid row -->
                <div class="row">

                    <!-- Grid column -->
                    <div class="col-md-6 mt-md-0 mt-3">

                        <!-- Content -->
                        <h5 class="text-uppercase">Website Trắc Nghiệm trực tuyến</h5>
                        <p>Để nâng cao kiến thức khi sử dụng trang web trắc nghiệm trực tuyến, bạn nên đọc kỹ hướng dẫn trước khi bắt đầu làm bài.
                            Bạn cũng nên thực hành làm bài trắc nghiệm thường xuyên để cải thiện kỹ năng và nâng cao kiến thức của mình trong các môn học khác nhau.</p>

                    </div>
                    <!-- Grid column -->

                    <hr class="clearfix w-100 d-md-none pb-3">

                    <!-- Grid column -->
                    <div class="col-md-3 mb-md-0 mb-3">

                        <!-- Links -->
                        <h5 class="text-uppercase">LIÊN KẾT</h5>

                        <ul class="list-unstyled" style="text-align: left; margin-left: 67px;" >
                            <li>
                                <a href="#!"> <strong>ĐỀ THI HK1,HK2</strong> </a>
                            </li>
                            <li>
                                <a href="#!" > <strong> KIỂM TRA 1 TIẾT</strong></a>
                            </li>
                            <li>
                                <a href="#!" ><strong>KIỂM TRA 15 PHÚT</strong></a>
                            </li>
                        </ul>

                    </div>
                    <!-- Grid column -->
                    <div class="col-md-3 mb-md-0 mb-3">

                        <!-- Links -->
                        <h5 class="text-uppercase">Liên Hệ</h5>

                        <ul class="list-unstyled" >
                            <li class="contact">
                                <strong>Điện thoại: </strong>
                                <strong>(+84) 236.3650403</strong>
                            </li>
                            <li class="contact">
                                <strong>Địa Chỉ: </strong>
                                <strong>(+84) 236.3650403</strong>
                            </li>
                            <li class="contact">
                                <strong>Gmail: </strong>
                                <strong>duytan2023@dtu.edu.vn</strong>

                            </li>
                        </ul>
                    </div>
                </div>
            </section>
            <!-- Section: Links -->
        </div>
        <!-- Grid container -->
        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            <a class="text-white" href="https://www.facebook.com/QuizGym-102791849085267" target="_blank"> © 2023 Copyright</a>
        </div>
    </footer>

    <script>
        var header = document.querySelector('.navbar__item-list');
        var content = document.querySelector('.container-fluid');
        var origOffsetY = header.offsetTop;
        function onScroll(e) {
            if(window.scrollY >= origOffsetY){
                header.classList.add('sticky');
                content.classList.add('top-padding-80');
            } else {
                header.classList.remove('sticky');
                content.classList.remove('top-padding-80');
            }
        }
        document.addEventListener('scroll', onScroll);
    </script>




    <style>
        .contact {
            text-align: left;
        }
        strong{
            color: black;
        }
    </style>
</div>