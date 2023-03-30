<!--    廖汉奇2023/03/29-->
<!--     廖汉奇2023/03/29 <#macro：名字叫宏，freemaker 的模板-->

<!--     廖汉奇2023/03/29 <macro layout title> 定义一个宏（模板），名字是 loyout，title 是参数-->
<#macro layout title>
<!-- 宏的作用，相当于把原来的index全部引了进来 -->
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <!-- 此处的title会被上面的那个title替换，上面的那个title会被index.ftl里面的”首页“二字引用过来 -->
  <title>${title}}</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="fly,layui,前端社区">
  <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
  <link rel="stylesheet" href="../res/layui/css/layui.css">
  <link rel="stylesheet" href="../res/css/global.css">



</head>
<body>

<!-- 廖汉奇2023/03/29  <include是抽出去，引进来 -->


<!--廖汉奇2023/03/29 第一顶部 header.ftl-->
<#include "/inc/header.ftl" />

    <#nested >


<!--廖汉奇2023/03/29 尾部  footer.ftl-->
<#include "/inc/footer.ftl" />

<script src="../res/layui/layui.js"></script>
<script>
layui.cache.page = '';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '../res/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "3.0.0"
  ,base: '../res/mods/' //这里实际使用时，建议改成绝对路径
}).extend({
  fly: 'index'
}).use('fly');
</script>

<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_30088308'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "w.cnzz.com/c.php%3Fid%3D30088308' type='text/javascript'%3E%3C/script%3E"));</script>

</body>
</html>

</#macro>