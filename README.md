# 监控摄像头 - HopewayCam 高仿版

基于 Hopeway/有我看家 v4.1.2 逆向分析制作的高仿 Android 项目。

## 功能
- 实时视频预览
- 摄像头设备列表管理
- 告警消息
- 云存储服务
- 添加设备
- 相册
- 设置
- **AI智能分析** (新增)
- **智能看板** (新增)

## 自动构建

本项目配置了 GitHub Actions CI，提交代码后自动编译 APK。

### 使用方法

1. 在手机上打开 GitHub App
2. Fork 或创建仓库
3. 把本目录文件上传到 GitHub 仓库
4. 进入 Actions 标签页，点击 "Build APK" workflow
5. 点击 "Run workflow" → 等待几分钟
6. 构建完成后在 Artifacts 下载 APK

### 手动构建
```bash
./gradlew assembleDebug
# APK 在 app/build/outputs/apk/debug/app-debug.apk
```

## 技术栈
- Kotlin + Java
- AndroidX + Material Design 3
- ViewBinding
- OkHttp + Gson
- ExoPlayer (Media3)
- Glide
- ZXing
