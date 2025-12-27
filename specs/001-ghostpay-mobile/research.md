# SubCatcher - Technology Research

## Android Kotlin Development

### Kotlin Version
- **Recommended**: Kotlin 1.9.0 or later
- **Features**: Coroutines, Flow, Sealed Classes, Data Classes
- **Compatibility**: Full Android API support

### Android SDK Versions
- **Minimum**: API 23 (Android 6.0) - 94.1% device coverage
- **Target**: API 34 (Android 14) - Latest stable
- **Compile**: API 34

## Architecture Patterns

### Clean Architecture
- **Benefits**: Separation of concerns, testability, maintainability
- **Layers**: Presentation, Domain, Data
- **Implementation**: Use cases, repositories, data sources

### MVVM Pattern
- **Benefits**: Lifecycle-aware, testable ViewModels
- **Implementation**: ViewModel + LiveData/StateFlow
- **Android Components**: ViewModel, LiveData, StateFlow

## Dependency Injection

### Hilt (Recommended)
- **Version**: 2.48+
- **Benefits**: Built on Dagger, Android-specific
- **Setup**: Requires Application class annotation
- **Documentation**: https://developer.android.com/training/dependency-injection/hilt-android

### Alternative: Koin
- **Version**: 3.5.0+
- **Benefits**: Lightweight, Kotlin-first
- **Consideration**: Simpler but less compile-time safety

## Database

### Room Database
- **Version**: 2.6.1+
- **Benefits**: SQLite abstraction, compile-time queries
- **Features**: Type converters, migrations, testing support
- **Encryption**: Consider SQLCipher for encrypted database

### DataStore (Preferences)
- **Version**: 1.0.0+
- **Benefits**: Type-safe, async, replaces SharedPreferences
- **Use Cases**: User preferences, settings

## Security

### Android Keystore System
- **Purpose**: Secure key storage in hardware (when available)
- **API**: KeyStore, KeyGenerator, Cipher
- **Benefits**: Keys never leave secure hardware
- **Documentation**: https://developer.android.com/training/articles/keystore

### Biometric Authentication
- **Library**: AndroidX Biometric Library 1.1.0+
- **Features**: Fingerprint, Face, Iris authentication
- **Fallback**: PIN/Password authentication
- **Documentation**: https://developer.android.com/training/sign-in/biometric-auth

### Encryption
- **Algorithm**: AES-256-GCM (recommended)
- **Key Derivation**: PBKDF2 or Argon2
- **Implementation**: Android Security APIs
- **Considerations**: Performance vs security trade-offs

## UI Framework

### Jetpack Compose (Recommended)
- **Version**: 1.5.0+
- **Benefits**: Declarative UI, Kotlin-first, modern
- **Learning Curve**: Moderate
- **Performance**: Good, improving
- **Documentation**: https://developer.android.com/jetpack/compose

### Alternative: View System
- **Benefits**: Mature, extensive documentation
- **Considerations**: XML layouts, more boilerplate
- **Use Case**: If team is more familiar with Views

## Async Operations

### Kotlin Coroutines
- **Version**: 1.7.3+
- **Benefits**: Lightweight threads, structured concurrency
- **Use Cases**: Network (if needed), database, background tasks
- **Documentation**: https://kotlinlang.org/docs/coroutines-overview.html

### Flow
- **Purpose**: Reactive streams for data
- **Use Cases**: Database observables, UI state
- **Benefits**: Cold streams, backpressure handling

## Image Processing (On-Device)

### Coil (If needed)
- **Version**: 2.5.0+
- **Purpose**: Image loading and caching
- **Benefits**: Kotlin-first, Coroutines-based
- **Note**: Only if image processing needed, all on-device

### Android Image Processing
- **APIs**: Bitmap, Canvas, ImageDecoder
- **Use Cases**: Image manipulation, compression
- **Considerations**: Memory management, performance

## Testing

### Unit Testing
- **Framework**: JUnit 5
- **Mocking**: MockK (Kotlin-first mocking)
- **Coroutines**: kotlinx-coroutines-test
- **Coverage**: Aim for 80%+

### Integration Testing
- **Framework**: JUnit 4/5
- **Database**: In-memory Room database
- **Security**: Test Keystore operations

### UI Testing
- **Framework**: Espresso or Compose Testing
- **Purpose**: Test user flows, UI interactions
- **Coverage**: Critical paths only

## Build & Dependencies

### Gradle
- **Version**: 8.2+
- **Kotlin DSL**: Recommended for Kotlin projects
- **Build Variants**: Debug, Release, Staging (optional)

### Key Dependencies
```kotlin
// Core Android
implementation("androidx.core:core-ktx:1.12.0")
implementation("androidx.appcompat:appcompat:1.6.1")
implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

// Compose (if using)
implementation("androidx.compose.ui:ui:1.5.4")
implementation("androidx.compose.material3:material3:1.1.2")

// Room
implementation("androidx.room:room-runtime:2.6.1")
implementation("androidx.room:room-ktx:2.6.1")
kapt("androidx.room:room-compiler:2.6.1")

// Hilt
implementation("com.google.dagger:hilt-android:2.48")
kapt("com.google.dagger:hilt-compiler:2.48")

// Coroutines
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

// Biometric
implementation("androidx.biometric:biometric:1.1.0")

// Testing
testImplementation("junit:junit:4.13.2")
testImplementation("io.mockk:mockk:1.13.8")
androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
```

## Performance Optimization

### ProGuard/R8
- **Purpose**: Code shrinking, obfuscation, optimization
- **Configuration**: Custom rules for reflection, serialization
- **Benefits**: Smaller APK, better performance

### Memory Profiling
- **Tool**: Android Studio Profiler
- **Focus**: Memory leaks, allocations, GC pressure
- **Target**: < 100MB average memory usage

### Startup Optimization
- **Techniques**: Lazy initialization, background threads
- **Measurement**: App Startup library
- **Target**: < 2 seconds cold start

## Privacy & Compliance

### Data Minimization
- **Principle**: Collect only necessary data
- **Storage**: All on-device, encrypted
- **Transmission**: Zero external transmission

### User Control
- **Settings**: Privacy settings screen
- **Data Export**: Allow users to export their data
- **Data Deletion**: Secure data deletion option

## NLP Model Development Research

### Model Architecture
- **Type**: Named Entity Recognition (NER)
- **Base Model**: Turkish pre-trained model (tr_core_news_tr from SpaCy) or BERT-tiny
- **Target Entities**: 
  - MERCHANT (Netflix, Spotify, etc.)
  - AMOUNT (229.00, 159.90, etc.)
  - CURRENCY (TL, TRY)
  - DATE (27/12, 2024-01-15, etc.)
- **Output Format**: BIO tagging (Beginning, Inside, Outside)

### Training Data Strategy

#### Data Collection Methods
1. **Synthetic Data Generation**:
   - Collect 10-20 real bank notification templates
   - Create Python script to generate 10,000+ variations
   - Vary: bank names, merchant names, amounts, dates, formats
   - Example template: `"{bank}: {card} ile {merchant} firmasında {amount} TL harcama yapıldı."`

2. **Real Data Sources** (for validation):
   - Şikayetvar.com (complaint forums with notification screenshots)
   - Donanımhaber.com (tech forums)
   - Personal collection from team members
   - Public forums (with permission)

3. **Data Augmentation**:
   - Synonym replacement (Netflix → NETFLIX → netflix)
   - Number variations (229.00 → 229,00 → 229 TL)
   - Date format variations (27/12 → 27.12.2024 → 2024-12-27)
   - Bank name variations (Garanti → GARANTI BBVA → Garanti Bank)

#### Data Labeling
- **Tool**: Label Studio (open-source labeling tool)
- **Format**: BIO (Beginning, Inside, Outside) tagging
- **Example**:
  ```
  GARANTI: 1234 ile NETFLIX firmasında 229.00 TL harcama yapıldı.
  O      O  O   O   B-MERCHANT O     B-AMOUNT B-CURRENCY O O O
  ```

### Model Training Pipeline

#### Option 1: SpaCy (Recommended for MVP)
- **Pros**: Fast training, good Turkish support, easy to use
- **Cons**: Less accurate than BERT-based models
- **Steps**:
  1. Load Turkish base model: `tr_core_news_tr`
  2. Add custom NER component
  3. Train on labeled data (10,000+ samples)
  4. Export model
  5. Convert to format usable in Android

#### Option 2: BERT-tiny + TensorFlow Lite
- **Pros**: Better accuracy, optimized for mobile
- **Cons**: More complex, requires TensorFlow knowledge
- **Steps**:
  1. Fine-tune BERT-tiny on Turkish banking notifications
  2. Convert to TensorFlow Lite format
  3. Optimize model size (< 20MB target)
  4. Integrate into Android app

#### Option 3: Hybrid Approach (Recommended)
- **Regex First**: Use regex patterns for common formats (fast, 100% accurate for known patterns)
- **NLP Fallback**: Use trained model for unknown/unusual formats
- **Fuzzy Matching**: Match merchant names with known subscription list

### Model Optimization for Android
- **Target Size**: < 20MB
- **Inference Time**: < 100ms per notification
- **Memory Usage**: < 50MB during inference
- **Format**: TensorFlow Lite (.tflite)
- **Quantization**: INT8 quantization to reduce size

## OCR (Google ML Kit) Research

### Google ML Kit Text Recognition
- **Version**: ML Kit Text Recognition v2
- **Language**: Turkish + English support
- **On-Device**: Yes, no cloud required
- **Accuracy**: 95%+ for printed text
- **Limitations**: Handwriting recognition not as accurate

### Screenshot Processing Strategy
1. **Image Preprocessing**:
   - Resize if too large (max 1920x1080)
   - Convert to grayscale (optional, may improve accuracy)
   - Enhance contrast if needed

2. **Text Extraction**:
   - Use ML Kit to extract all text with bounding boxes
   - Group text by proximity (rows/columns)
   - Identify subscription patterns:
     - Service name + price pairs
     - Date information
     - Recurring indicators ("Monthly", "Annual")

3. **Data Mapping**:
   - Match service names with known subscription list
   - Extract prices (look for TL, TRY, currency symbols)
   - Parse dates (various formats)

### Play Store Subscriptions Page Format
- **Structure**: Service name, price, next billing date, status
- **Challenges**: Different layouts, languages, screen sizes
- **Solution**: Flexible parsing with multiple pattern matching

### Bank Transaction History Format
- **Structure**: Date, merchant, amount, status
- **Challenges**: Different bank formats, mixed transactions
- **Solution**: Filter for subscription-related keywords, user confirmation

## Notification Listener Service Research

### Android NotificationListenerService
- **API Level**: Available from API 18+ (Android 4.3)
- **Permission**: `BIND_NOTIFICATION_LISTENER_SERVICE` (special permission)
- **User Action Required**: User must enable in Settings > Accessibility
- **Google Play Policy**: Must clearly explain why notification access is needed

### Implementation Details
- **Service Class**: Extend `NotificationListenerService`
- **Key Methods**:
  - `onNotificationPosted()`: Called when notification arrives
  - `getActiveNotifications()`: Get current notifications
- **Notification Data Access**:
  - `Notification.EXTRA_TITLE`: Notification title
  - `Notification.EXTRA_TEXT`: Notification body text
  - `Notification.EXTRA_SUMMARY_TEXT`: Summary text

### Permission Flow
1. Request notification access permission
2. Direct user to Settings > Accessibility
3. User enables service manually
4. Service starts automatically
5. Monitor service status (may be disabled by user/system)

### Background Processing
- **WorkManager**: For reliable background tasks
- **Foreground Service**: Optional, for better reliability
- **Battery Optimization**: Request exemption from battery optimization
- **Doze Mode**: Handle app standby and doze mode

## Research Questions to Resolve

1. **NLP Model Training**: SpaCy vs BERT-tiny vs Hybrid approach?
2. **Training Data**: How many samples needed for 90%+ accuracy?
3. **Model Size**: Can we achieve < 20MB with good accuracy?
4. **OCR Accuracy**: ML Kit accuracy for Turkish bank screenshots?
5. **Notification Reliability**: How to ensure notifications aren't missed?
6. **Battery Impact**: What's the battery cost of notification listening?
7. **Permission UX**: Best way to explain notification access to users?
8. **Data Privacy**: How to ensure no sensitive data (card numbers) is stored?

## Next Steps

1. **Collect Real Notification Samples**: Gather 50-100 real bank notifications
2. **Create Synthetic Dataset**: Generate 10,000+ training samples
3. **Train Initial Model**: Start with SpaCy for MVP
4. **Test OCR Accuracy**: Test ML Kit on various screenshot formats
5. **Build POC**: Create proof-of-concept for notification parsing
6. **Benchmark Performance**: Test on various Android devices
7. **Security Audit**: Review all data handling for privacy compliance
8. **Update Implementation Plan**: Finalize technical decisions

