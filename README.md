# Googleglass

### 2020.08.18
- 카메라, 갤러리 어플 기본 사용 가능
- 카메라 사진 촬영 후 서버 전송을 위한 모듈 구현 필요
- CameraActionHandler.java에서 카메라 액션 제어, FTP 업로드 위한 모듈 구현 중 (촬영된 이미지 path 등 데이터 호출하는 방안 확인)
- 기존 촬영된 이미지로 테스트 중 네트워크 연결은 메인 쓰레드에서 진행이 되지 않아 AsyncTask 클래스 활용하여 구현 중
(참고 링크: https://lovemewithoutall.github.io/it/networkOnMainThreadException/)
