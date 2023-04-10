<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <script src="https://kit.fontawesome.com/a2a797ca33.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
        integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="styles/style.css">

  <script
  src="https://code.jquery.com/jquery-3.6.4.js"
  integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
  crossorigin="anonymous"></script>

  <title>HEROES</title>
</head>
<body>
<div id="container-header">
  <header class="header">
    <div class="header-image">
      <svg width="372" height="60" viewBox="0 0 124 20" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path d="M33.0147 15.8109H31.5935V3.98404H33.2209C34.6287 3.98404 38.296 4.94322 38.296 9.94433C38.296 14.9454 34.2655 15.8154 33.0192 15.8154L33.0147 15.8109ZM33.342 0.258856H27.173V19.5406H33.1537C37.1483 19.5406 42.9317 17.0869 42.9317 9.93987C42.9317 2.79287 36.6775 0.254395 33.3375 0.254395"
              fill="#c5c5c5"></path>
        <path d="M51.1361 16.5738C49.3293 16.5738 47.8633 15.0837 47.8633 13.2456C47.8633 11.4076 49.3293 9.91751 51.1361 9.91751C52.9428 9.91751 54.4088 11.4076 54.4088 13.2456C54.4088 15.0837 52.9428 16.5738 51.1361 16.5738ZM54.6689 6.96413V8.72634L54.1398 8.13299C53.6018 7.53071 52.4138 6.52246 50.4681 6.52246C48.7599 6.52246 47.0922 7.18273 45.9982 8.2936C45.2809 9.02079 44.0794 10.6492 44.0794 13.3661C44.0794 15.2354 44.6308 16.663 45.8593 18.0014C47.0966 19.3264 48.5985 20 50.3201 20C51.2706 20 53.0235 19.7725 54.1174 18.2378L54.6644 17.4705V19.5584H58.3093V6.95967H54.6689V6.96413Z"
              fill="#c5c5c5"></path>
        <path d="M76.7803 16.5738C74.9735 16.5738 73.5075 15.0837 73.5075 13.2456C73.5075 11.4076 74.9735 9.91751 76.7803 9.91751C78.587 9.91751 80.0531 11.4076 80.0531 13.2456C80.0531 15.0837 78.587 16.5738 76.7803 16.5738ZM80.3131 6.96413V8.72634L79.7841 8.13299C79.2461 7.53071 78.058 6.52246 76.1123 6.52246C74.4042 6.52246 72.7364 7.18273 71.6425 8.2936C70.9251 9.02079 69.7236 10.6492 69.7236 13.3661C69.7236 15.2354 70.2751 16.663 71.5035 18.0014C72.7409 19.3264 74.2428 20 75.9643 20C76.9148 20 78.6677 19.7725 79.7616 18.2378L80.3086 17.4705V19.5584H83.9535V6.95967H80.3131V6.96413Z"
              fill="#c5c5c5"></path>
        <path d="M62.2232 0.259033V6.96436H60.7392V10.2211H62.2232V19.5541H66.2715V10.2211H68.9211V6.96436H66.2715V0.259033H62.2232Z"
              fill="#c5c5c5"></path>
        <path d="M117.031 0.254395V19.554H121.079V10.2209H123.729V6.96419H121.079V0.254395H117.031Z"
              fill="#c5c5c5"></path>
        <path d="M95.5024 4.796L98.3089 13.0048H92.7676L95.5024 4.796ZM93.0321 0.254395L85.7423 19.5406H90.3018L91.6378 16.1634H99.3938L100.613 19.5406H105.222L98.0713 0.254395H93.0321Z"
              fill="#c5c5c5"></path>
        <path d="M106.693 19.5539H110.741V14.2138C110.741 13.6784 110.741 12.0411 111.884 10.9793C112.458 10.4484 113.22 10.1897 114.215 10.1897C114.901 10.1897 115.65 10.2075 115.919 10.212V6.97308C115.731 6.9597 115.112 6.92847 115.112 6.92847C114.328 6.92847 113.588 6.92847 113.023 7.24076C112.297 7.61105 111.705 8.19994 111.31 8.94943L110.736 10.038V6.96416H106.688V19.5584L106.693 19.5539Z"
              fill="#c5c5c5"></path>
        <path d="M14.537 5.07601L9.68988 9.89941L14.537 14.7228L19.3842 9.89941L14.537 5.07601Z" fill="#FFDE55"></path>
        <path d="M19.3811 9.89972L14.5347 5.07706L19.3811 0.254395V9.89972Z" fill="#2BC6BF"></path>
        <path d="M4.84637 14.7179L9.69278 9.89966L14.5347 14.7179H4.84637Z" fill="#F0503C"></path>
        <path d="M9.69281 19.5405L19.3811 9.89966V19.5405H9.69281Z" fill="#53CFF8"></path>
        <path d="M9.69281 19.5407L14.5347 14.718H4.8464L0 19.5407H9.69281Z" fill="#70529F"></path>
        <path d="M0 0.254395L9.69281 9.89972L19.3811 0.254395H0Z" fill="#284086"></path>
        <path d="M0 19.5406L9.69281 9.89972L0 0.254395V19.5406Z" fill="#FFB133"></path>
      </svg>
    </div>
    <div class="header-text">
      <h1>DataArt Trainee Program</h1>
      <h3>Exercise 3 - Heroes Web API</h3>

      <h5>Trainee: Matias Inglesi</h5>
      <h5>Mentor: Alexander Elgier</h5>
    </div>


  </header>
</div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <ul class="navbar-nav mr-auto">
    <li class="${ param.activePage == 'index' ? 'nav-item active' : 'nav-item' }">
      <a class="nav-link" href="/HeroApp/index.jsp">Home <span class="sr-only">(current)</span></a>
    </li>
    <li class="${ param.activePage == 'heroes' ? 'nav-item active' : 'nav-item' }">
      <a class="nav-link" href="/HeroApp/heroes.jsp">Hero List</a>
    </li>
    <li class="${ param.activePage == 'hero' ? 'nav-item active' : 'nav-item' }">
      <a class="nav-link" href="/HeroApp/hero.jsp">Create Hero</a>
    </li>
  </ul>
</nav>


