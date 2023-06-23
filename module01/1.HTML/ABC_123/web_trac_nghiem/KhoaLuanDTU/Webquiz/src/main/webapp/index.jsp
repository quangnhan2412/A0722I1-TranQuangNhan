<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/view/head.jsp"/>
    <title>Website thi trắc nghiệm online</title>
    <style>
        .run {
            height: 70%;
            position: relative;
        }
        .honour_bottom{
            position: sticky;
            top:10px;
        }

    </style>
</head>
<body style="max-width: 1620px">
<jsp:include page="/view/header.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <div class="honour">
                <div class="gold_pound">
                    <i class="fa-solid fa-award"></i>
                    <p>Vinh danh thí sinh</p>
                </div>
                <div class="div_group">
                    <ul class="list-group">
                        <c:forEach var="member" items="${memberList}">
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                <span><c:out value="${member.name}"></c:out></span>
                                <span class="badge badge-primary badge-pill test1">
                                        ${member.point}
                                </span>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="run">
                <div class="honour honour_bottom">
                    <div class="gold_pound">
                        <i class="fa-regular fa-comment-arrow-down"></i>
                        <p>Hỗ trợ trực tuyến</p>
                    </div>
                    <div class="div_group_call">
                        <ul class="list-group">
                            <li class="list-group-item">
                                <a class="d-flex justify-content-between align-items-center" href="https://web.skype.com/chat/" target="_blank">
                                    ONLINE
                                    <span class="badge badge-primary badge-pill test1">Phuc</span>
                                </a>
                            </li>
                            <li class="list-group-item">
                                <a class="d-flex justify-content-between align-items-center" href="https://web.skype.com/" target="_blank">
                                    HOTLINE
                                    <span class="badge badge-primary badge-pill test1">0935338475</span>
                                </a>
                            </li>
                            <li class="list-group-item">
                                <a class="d-flex justify-content-between align-items-center" href="https://www.facebook.com/profile.php?id=100026751636172" target="_blank">
                                    FB cá nhân
                                    <span class="badge badge-primary badge-pill test1">Phuc Nguyen</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div>
                        <p> &emsp; Hệ thống thi và tạo đề thi trắc nghiệm online &emsp;tốt nhất. Hỗ trợ bạn các chức năng tốt nhất để &emsp;dễ dàng tạo và
                            quản lý ngân hàng câu hỏi, đề &emsp;thi trắc nghiệm.
                            Tổ chức các kỳ thi online, giao &emsp; bài tập về nhà trên mọi nền tảng Web.</p>
                    </div>
                </div>
            </div>

        </div>


        <div class="col-6 col-md-6">
            <br>
            <div><h1 style="text-align: center; font-family: Lucida Console Monaco; font-style: italic">--- Các môn nổi bật ---</h1></div>
            <div class="row">
                <a href="/exam_list?action=list_exam&sj_id=1" class="col-6">
                    <div class="card card_mg">
                        <img class="card-img-top" src="../static/img/Toan.png" style="height: 300px; object-fit: cover" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Toán Học</h5>
                        </div>
                    </div>
                </a>
                <a href="/exam_list?action=list_exam&sj_id=3" class="col-6">
                    <div class="card card_mg">
                        <img class="card-img-top" src="../static/img/hóa.png" style="height: 300px; object-fit: cover"
                             alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Hóa Học</h5>
                        </div>
                    </div>
                </a>

                <a href="/exam_list?action=list_exam&sj_id=2" class=" col-6">
                    <div class="card card_mg">
                        <img class="card-img-top" src="../static/img/lý.png" style="height: 300px" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Vật Lý</h5>

                        </div>
                    </div>
                </a>
                <a href="/exam_list?action=list_exam&sj_id=7" class=" col-6">
                    <div class="card card_mg">
                        <img class="card-img-top" src="../static/img/tiếng_anh.png"
                             style="height: 300px" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Tiếng Anh</h5>
                        </div>
                    </div>
                </a>
                <a href="/exam_list?action=list_exam&sj_id=5" class="col-6">
                    <div class="card card_mg">
                        <img class="card-img-top" src="../static/img/bằng_lái_xe.png" style="height: 300px"
                             alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Thi Bằng Lái Xe</h5>

                        </div>
                    </div>
                </a>
                <a href="/exam_list?action=list_exam&sj_id=4" class=" col-6">
                    <div class="card card_mg">
                        <img class="card-img-top" src="../static/img/ngôn ngữ lập trình.png" style="height: 300px"
                             alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Ngôn Ngữ Lập Trình</h5>
                        </div>
                    </div>
                </a>
            </div>
        </div>



        <div class="col-3 col-md-3 ">
            <div class="honour">
                <div class="gold_pound">
                    <c:set var="role" scope="session" value="${sessionScope.account.idRole}"/>
                    <i class="fa-solid fa-user"></i>
                    <c:choose>
                        <c:when test="${role == 1}">
                        <p>ADMIN</p>
                    </c:when>
                        <c:when test="${role == 2}">
                            <p>Thành viên</p>
                        </c:when>
                        <c:when test="${role == 3}">
                            <p>Teacher</p>
                        </c:when>
                        <c:otherwise>
                            <p>Chào bạn</p>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="user_log">
                    <div class="div_cus">
                        <ul class="list-group">
                            <c:if test="${sessionScope.account == null}">
                                <li class="list-group-item d-flex justify-content-between align-items-center">Đăng nhập vào thi để nâng kiến thức nào!</li>
                            </c:if>
                            <c:if test="${sessionScope.account != null}">
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                <form action="/userServlet" method="post">
                                    <input type="hidden" name="action" value="infoUser">
                                    <input type="hidden" name="index" value="">
                                    <input type="hidden" name="check" value="">
                                    <input type="hidden" name="idUser" value="${sessionScope.user.userId}">
                                        <button class="btn_info" type="submit">
                                            <i class="fa-solid fa-gear"></i>
                                            <span>Thông tin cá nhân</span>
                                        </button>
                                </form>
                            </li>
                            </c:if>

                        </ul>
                    </div>
                </div>
                <div class="user_log">
                    <div class="div_thongke">
<%--                        <div class="div_cus-link"  style="text-decoration: none; color: black">--%>
<%--                            <i class="fa-solid fa-user-group"></i>--%>
<%--                            <p>Thành viên </p>--%>
<%--                        </div>--%>
                        <ul class="list-group">
<%--                            <li class="list-group-item d-flex justify-content-between align-items-center">--%>
<%--                                Tổng Thành Viên--%>
<%--                                <span class="badge badge-primary badge-pill test1">${memberList2.size()}</span>--%>
<%--                            </li>--%>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                               Thành viên mới nhất
                                <span class="badge badge-primary badge-pill test1">${newMember.name}</span>
                            </li>
                        </ul>
                    </div>
                </div>

            </div>
            <br><br><br><br>
            <div>
                <h5 style="font-style: italic; margin-left: 46px">Đề thi trắc nghiệm môn toán</h5>
               <img src="/static/img/Thiết-kế-không-tên-1-1.png" style="width: 100% ;height: 200px; object-fit: cover">
               <a href="/exam_list?action=list_exam&sj_id=1"  class="badge badge-primary badge-pill test1" style="font-style: italic; font-size: 20px; margin-left: 114px">*XEM NGAY*</a>
            </div>
            <br><br>
            <div>
                <h5 style="font-style: italic; margin-left: 46px">Đề thi trắc nghiệm môn lý</h5>
                <img src="/static/img/de_mon_ly.jpg" style="width: 100% ;height: 200px; object-fit: cover;margin-bottom: 5px;">
                <a href="/exam_list?action=list_exam&sj_id=2"  class="badge badge-primary badge-pill test1" style="font-style: italic; font-size: 20px; margin-left: 114px">*XEM NGAY*</a>
            </div>
            <br><br>
            <div>
                <h5 style="font-style: italic; margin-left: 46px">Đề thi trắc nghiệm môn ngữ văn</h5>
                <img src="/static/img/de_mon_van.jpg" style="width: 100% ;height: 200px; object-fit: cover;margin-bottom: 5px;">
                <a href="/exam_list?action=list_exam&sj_id=9"  class="badge badge-primary badge-pill test1" style="font-style: italic; font-size: 20px; margin-left: 114px">*XEM NGAY*</a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/view/footer.jsp"/>
<jsp:include page="/view/messenger.jsp"/>
</body>
</html>
