# SubCatcher

**Privacy-First Subscription Tracking for Android**

SubCatcher automatically tracks your digital subscriptions by analyzing bank notifications and screenshots - all processed on-device with zero data transmission.

## 🎯 Features

- **Automatic Detection**: Reads bank notifications to detect subscription payments
- **OCR Analysis**: Upload screenshots to extract subscription information
- **Privacy First**: All processing happens on-device, no external servers
- **Smart Alerts**: Get notified before payments are charged
- **Ghost Subscription Detection**: Identify forgotten subscriptions

## 🛠️ Technology Stack

- **Language**: Kotlin
- **Platform**: Android Native
- **Architecture**: Clean Architecture + MVVM
- **OCR**: Google ML Kit (on-device)
- **NLP**: TensorFlow Lite (custom model)
- **Database**: Room Database (encrypted)
- **Security**: Android Keystore

## 📁 Project Structure

```
SubCatcher/
├── app/                    # Android application
├── memory/                 # Project constitution and principles
├── specs/                  # Feature specifications
│   └── 001-subcatcher-mobile/
│       ├── spec.md        # Feature specifications
│       ├── plan.md        # Technical implementation plan
│       ├── research.md    # Technology research
│       └── tasks.md       # Task breakdown
├── scripts/                # Automation scripts
├── templates/              # Spec templates
└── CLAUDE.md              # Spec-driven development coordination
```

## 🚀 Getting Started

### Prerequisites

- Android Studio
- Kotlin 1.9+
- Android SDK 23+ (Android 6.0)
- Gradle 8.2+

### Development

This project uses Spec-Driven Development methodology. See `CLAUDE.md` for development workflow.

## 📄 License

[To be determined]

## 👤 Author

**Samed Temiz**

- GitHub: [@SamedTemiz](https://github.com/SamedTemiz)

## 🙏 Acknowledgments

- Built using [GitHub Spec-Kit](https://github.com/github/spec-kit) for spec-driven development

