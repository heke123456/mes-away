echo.
echo [信息] 清理工程target生成路径。
echo.

%~d0
cd %~dp0

cd ..
call mvn clean

echo.
echo [信息] 打包Web工程，生成war/jar包文件。
echo.

%~d0
cd %~dp0

cd ..
call mvn clean package -Dmaven.test.skip=true

echo.
echo [信息] 使用Jar命令运行Web工程。
echo.

cd %~dp0
cd ../away-admin/target

set JAVA_OPTS=-Xms256m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m

java -jar %JAVA_OPTS% away-admin.jar

cd bin
pause

