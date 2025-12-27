# SubCatcher - Implementation Tasks

## Task Organization

Tasks are organized by implementation phase and user story. Each task includes:
- **ID**: Unique task identifier
- **Description**: What needs to be done
- **Dependencies**: Tasks that must be completed first
- **Estimated Effort**: Time estimate (if applicable)
- **Status**: Not Started / In Progress / Completed

## Phase 1: Project Setup

### 1.1 Initialize Android Project
- **ID**: TASK-001
- **Description**: Create new Android project with Kotlin, configure Gradle
- **Dependencies**: None
- **Files**: `build.gradle.kts`, `settings.gradle.kts`, `app/build.gradle.kts`
- **Status**: Not Started

### 1.2 Configure Build Variants
- **ID**: TASK-002
- **Description**: Set up debug and release build variants with appropriate configurations
- **Dependencies**: TASK-001
- **Files**: `app/build.gradle.kts`
- **Status**: Not Started

### 1.3 Set Up Dependency Injection
- **ID**: TASK-003
- **Description**: Configure Hilt for dependency injection, create Application class
- **Dependencies**: TASK-001
- **Files**: `Application.kt`, `di/AppModule.kt`
- **Status**: Not Started

### 1.4 Create Project Structure
- **ID**: TASK-004
- **Description**: Create package structure (data, domain, presentation, di)
- **Dependencies**: TASK-001
- **Files**: Package structure
- **Status**: Not Started

## Phase 2: Core Infrastructure

### 2.1 Set Up Room Database
- **ID**: TASK-005
- **Description**: Configure Room database, create database class, set up migrations
- **Dependencies**: TASK-004
- **Files**: `data/local/database/AppDatabase.kt`, `data/local/database/entities/`
- **Status**: Not Started

### 2.2 Implement Android Keystore Integration
- **ID**: TASK-006
- **Description**: Create Keystore manager for secure key storage and retrieval
- **Dependencies**: TASK-004
- **Files**: `data/local/keystore/KeystoreManager.kt`
- **Status**: Not Started

### 2.3 Create Encryption Utilities
- **ID**: TASK-007
- **Description**: Implement AES encryption/decryption utilities using Keystore keys
- **Dependencies**: TASK-006
- **Files**: `data/local/security/EncryptionManager.kt`
- **Status**: Not Started

### 2.4 Set Up Secure Storage
- **ID**: TASK-008
- **Description**: Implement secure storage for preferences using DataStore with encryption
- **Dependencies**: TASK-007
- **Files**: `data/local/preferences/SecurePreferences.kt`
- **Status**: Not Started

### 2.5 Configure Logging
- **ID**: TASK-009
- **Description**: Set up on-device logging (no external transmission)
- **Dependencies**: TASK-004
- **Files**: `utils/Logger.kt`
- **Status**: Not Started

## Phase 3: NLP Model Development

### 3.1 Collect Bank Notification Templates
- **ID**: TASK-010
- **Description**: Collect 50-100 real bank notification samples from various Turkish banks
- **Dependencies**: None
- **Files**: `ml/data/raw_notifications/`
- **Status**: Not Started

### 3.2 Create Synthetic Data Generator
- **ID**: TASK-011
- **Description**: Build Python script to generate 10,000+ synthetic notification samples
- **Dependencies**: TASK-010
- **Files**: `ml/scripts/generate_synthetic_data.py`
- **Status**: Not Started

### 3.3 Label Training Data
- **ID**: TASK-012
- **Description**: Label notifications using Label Studio (BIO format: MERCHANT, AMOUNT, CURRENCY, DATE)
- **Dependencies**: TASK-011
- **Files**: `ml/data/labeled/`
- **Status**: Not Started

### 3.4 Train NLP Model
- **ID**: TASK-013
- **Description**: Train NER model using SpaCy or BERT-tiny on labeled data
- **Dependencies**: TASK-012
- **Files**: `ml/models/ner_model/`
- **Status**: Not Started

### 3.5 Convert Model to TensorFlow Lite
- **ID**: TASK-014
- **Description**: Convert trained model to TFLite format, optimize size (< 20MB)
- **Dependencies**: TASK-013
- **Files**: `ml/models/subscription_ner.tflite`
- **Status**: Not Started

### 3.6 Integrate TFLite Model into Android
- **ID**: TASK-015
- **Description**: Add TFLite model to app assets, create inference wrapper
- **Dependencies**: TASK-014, TASK-004
- **Files**: `data/ml/NLPParser.kt`, `data/ml/ModelInference.kt`
- **Status**: Not Started

### 3.7 Test Model Accuracy
- **ID**: TASK-016
- **Description**: Test model with real notifications, measure accuracy (target: 90%+)
- **Dependencies**: TASK-015
- **Files**: `test/ml/ModelAccuracyTest.kt`
- **Status**: Not Started

## Phase 4: Notification Listener Service

### 4.1 Implement NotificationListenerService
- **ID**: TASK-017
- **Description**: Create service class extending NotificationListenerService
- **Dependencies**: TASK-004
- **Files**: `data/notifications/SubscriptionNotificationService.kt`
- **Status**: Not Started

### 4.2 Create Notification Filtering Logic
- **ID**: TASK-018
- **Description**: Filter notifications for subscription-related keywords (Netflix, Spotify, ödeme, etc.)
- **Dependencies**: TASK-017
- **Files**: `data/notifications/NotificationFilter.kt`
- **Status**: Not Started

### 4.3 Integrate NLP Model for Parsing
- **ID**: TASK-019
- **Description**: Use NLP model to extract merchant, amount, date from notification text
- **Dependencies**: TASK-015, TASK-018
- **Files**: `data/notifications/NotificationParser.kt`
- **Status**: Not Started

### 4.4 Implement Permission Flow
- **ID**: TASK-020
- **Description**: Create UI to request notification access, guide user to Settings
- **Dependencies**: TASK-017
- **Files**: `presentation/ui/screens/permissions/NotificationPermissionScreen.kt`
- **Status**: Not Started

### 4.5 Handle Service Status Monitoring
- **ID**: TASK-021
- **Description**: Monitor if notification service is enabled, handle re-enablement
- **Dependencies**: TASK-017
- **Files**: `data/notifications/NotificationServiceManager.kt`
- **Status**: Not Started

### 4.6 Test Notification Processing
- **ID**: TASK-022
- **Description**: Test with various bank notification formats, verify parsing accuracy
- **Dependencies**: TASK-019
- **Files**: `test/notifications/NotificationParsingTest.kt`
- **Status**: Not Started

## Phase 5: OCR (Screenshot Analysis)

### 5.1 Integrate Google ML Kit Text Recognition
- **ID**: TASK-023
- **Description**: Add ML Kit dependency, configure Text Recognition v2
- **Dependencies**: TASK-001
- **Files**: `app/build.gradle.kts`, `data/ocr/MLKitOCRProcessor.kt`
- **Status**: Not Started

### 5.2 Create Screenshot Upload UI
- **ID**: TASK-024
- **Description**: Build UI for selecting screenshot from gallery or taking photo
- **Dependencies**: TASK-004
- **Files**: `presentation/ui/screens/ocr/ScreenshotUploadScreen.kt`
- **Status**: Not Started

### 5.3 Implement Image Preprocessing
- **ID**: TASK-025
- **Description**: Resize, enhance contrast, convert to optimal format for OCR
- **Dependencies**: TASK-023
- **Files**: `data/ocr/ImagePreprocessor.kt`
- **Status**: Not Started

### 5.4 Extract Text from Screenshots
- **ID**: TASK-026
- **Description**: Use ML Kit to extract text with coordinates from images
- **Dependencies**: TASK-023, TASK-025
- **Files**: `data/ocr/OCRTextExtractor.kt`
- **Status**: Not Started

### 5.5 Parse Play Store Subscriptions Format
- **ID**: TASK-027
- **Description**: Parse extracted text to find service name + price pairs from Play Store format
- **Dependencies**: TASK-026
- **Files**: `data/ocr/PlayStoreParser.kt`
- **Status**: Not Started

### 5.6 Parse Bank Transaction History Format
- **ID**: TASK-028
- **Description**: Parse extracted text to find transactions from bank history screenshots
- **Dependencies**: TASK-026
- **Files**: `data/ocr/BankHistoryParser.kt`
- **Status**: Not Started

### 5.7 Create Confirmation Flow
- **ID**: TASK-029
- **Description**: Show detected subscriptions to user, allow editing/confirmation before saving
- **Dependencies**: TASK-027, TASK-028
- **Files**: `presentation/ui/screens/ocr/SubscriptionConfirmationScreen.kt`
- **Status**: Not Started

### 5.8 Implement Image Deletion
- **ID**: TASK-030
- **Description**: Delete processed screenshots immediately after OCR (privacy)
- **Dependencies**: TASK-026
- **Files**: `data/ocr/ImageCleanup.kt`
- **Status**: Not Started

## Phase 6: Authentication

### 6.1 Create Authentication Domain Models
- **ID**: TASK-031
- **Description**: Define authentication data models and use cases
- **Dependencies**: TASK-004
- **Files**: `domain/models/AuthModels.kt`, `domain/usecases/AuthUseCases.kt`
- **Status**: Not Started

### 6.2 Implement Biometric Authentication
- **ID**: TASK-032
- **Description**: Integrate AndroidX Biometric library for fingerprint/face authentication
- **Dependencies**: TASK-031, TASK-006
- **Files**: `data/local/auth/BiometricAuthManager.kt`
- **Status**: Not Started

### 6.3 Implement PIN/Password Authentication
- **ID**: TASK-033
- **Description**: Create PIN/Password authentication with secure storage
- **Dependencies**: TASK-031, TASK-008
- **Files**: `data/local/auth/PinAuthManager.kt`
- **Status**: Not Started

### 6.4 Create Authentication Repository
- **ID**: TASK-034
- **Description**: Implement authentication repository interface and implementation
- **Dependencies**: TASK-032, TASK-033
- **Files**: `domain/repositories/AuthRepository.kt`, `data/repositories/AuthRepositoryImpl.kt`
- **Status**: Not Started

### 6.5 Build Authentication UI
- **ID**: TASK-035
- **Description**: Create authentication screens (login, PIN setup, biometric setup)
- **Dependencies**: TASK-034
- **Files**: `presentation/ui/screens/auth/`
- **Status**: Not Started

### 6.6 Implement Session Management
- **ID**: TASK-036
- **Description**: Create secure session management with auto-lock
- **Dependencies**: TASK-034
- **Files**: `domain/usecases/SessionManager.kt`
- **Status**: Not Started

## Phase 7: Subscription Management

### 7.1 Design Subscription Data Models
- **ID**: TASK-037
- **Description**: Create subscription entity models (name, amount, frequency, next payment date)
- **Dependencies**: TASK-004
- **Files**: `domain/models/SubscriptionModels.kt`, `data/local/database/entities/SubscriptionEntity.kt`
- **Status**: Not Started

### 7.2 Implement Subscription Storage
- **ID**: TASK-038
- **Description**: Create Room entities and DAOs for subscription storage
- **Dependencies**: TASK-005, TASK-037
- **Files**: `data/local/database/entities/SubscriptionEntity.kt`, `data/local/database/dao/SubscriptionDao.kt`
- **Status**: Not Started

### 7.3 Create Subscription Repository
- **ID**: TASK-039
- **Description**: Implement subscription repository with CRUD operations
- **Dependencies**: TASK-038
- **Files**: `domain/repositories/SubscriptionRepository.kt`, `data/repositories/SubscriptionRepositoryImpl.kt`
- **Status**: Not Started

### 7.4 Build Subscription List UI
- **ID**: TASK-040
- **Description**: Create subscription list screen with cards showing details
- **Dependencies**: TASK-039
- **Files**: `presentation/ui/screens/subscriptions/SubscriptionListScreen.kt`
- **Status**: Not Started

### 7.5 Create Subscription Detail Screen
- **ID**: TASK-041
- **Description**: Build detail screen showing payment history, annual cost, etc.
- **Dependencies**: TASK-039
- **Files**: `presentation/ui/screens/subscriptions/SubscriptionDetailScreen.kt`
- **Status**: Not Started

### 7.6 Implement Subscription Editing
- **ID**: TASK-042
- **Description**: Allow users to edit subscription details (amount, frequency, etc.)
- **Dependencies**: TASK-039
- **Files**: `presentation/ui/screens/subscriptions/EditSubscriptionScreen.kt`
- **Status**: Not Started

### 7.7 Add Subscription Deletion
- **ID**: TASK-043
- **Description**: Implement subscription deletion with confirmation dialog
- **Dependencies**: TASK-039
- **Files**: Update subscription repository and UI
- **Status**: Not Started

## Phase 8: Alert & Notification System

### 8.1 Set Up WorkManager
- **ID**: TASK-044
- **Description**: Configure WorkManager for reliable background alert scheduling
- **Dependencies**: TASK-001
- **Files**: `data/alerts/AlertWorkManager.kt`
- **Status**: Not Started

### 8.2 Implement Alert Calculation Logic
- **ID**: TASK-045
- **Description**: Calculate when to send alerts (24h before, 1h before payment)
- **Dependencies**: TASK-039, TASK-044
- **Files**: `domain/usecases/AlertCalculationUseCase.kt`
- **Status**: Not Started

### 8.3 Implement Price Increase Detection
- **ID**: TASK-046
- **Description**: Compare current payment with previous to detect price increases
- **Dependencies**: TASK-039
- **Files**: `domain/usecases/PriceIncreaseDetectionUseCase.kt`
- **Status**: Not Started

### 8.4 Create Ghost Subscription Detection
- **ID**: TASK-047
- **Description**: Detect subscriptions paid for 3+ months with no usage updates
- **Dependencies**: TASK-039
- **Files**: `domain/usecases/GhostSubscriptionDetectionUseCase.kt`
- **Status**: Not Started

### 8.5 Build Push Notification System
- **ID**: TASK-048
- **Description**: Create notification channels and send alerts to users
- **Dependencies**: TASK-045
- **Files**: `data/notifications/AlertNotificationManager.kt`
- **Status**: Not Started

### 8.6 Create Notification Settings UI
- **ID**: TASK-049
- **Description**: Build settings screen for alert preferences (timing, types)
- **Dependencies**: TASK-048
- **Files**: `presentation/ui/screens/settings/NotificationSettingsScreen.kt`
- **Status**: Not Started

### 8.7 Test Alert Timing
- **ID**: TASK-050
- **Description**: Test alert system with various scenarios, verify timing accuracy
- **Dependencies**: TASK-048
- **Files**: `test/alerts/AlertTimingTest.kt`
- **Status**: Not Started

## Phase 9: Dashboard & Timeline

### 9.1 Create Dashboard Screen
- **ID**: TASK-051
- **Description**: Build dashboard showing upcoming payments, total monthly cost
- **Dependencies**: TASK-039
- **Files**: `presentation/ui/screens/dashboard/DashboardScreen.kt`
- **Status**: Not Started

### 9.2 Implement Timeline View
- **ID**: TASK-052
- **Description**: Create timeline showing upcoming payments in next 30 days
- **Dependencies**: TASK-051
- **Files**: `presentation/ui/components/TimelineView.kt`
- **Status**: Not Started

### 9.3 Add Total Cost Calculation
- **ID**: TASK-053
- **Description**: Calculate and display total monthly/annual subscription costs
- **Dependencies**: TASK-039
- **Files**: `domain/usecases/TotalCostCalculationUseCase.kt`
- **Status**: Not Started

## Phase 10: UI/UX

### 6.1 Implement Material Design Theme
- **ID**: TASK-026
- **Description**: Create Material Design 3 theme with color schemes
- **Dependencies**: TASK-001
- **Files**: `presentation/ui/theme/Theme.kt`, `presentation/ui/theme/Color.kt`
- **Status**: Not Started

### 6.2 Create Reusable UI Components
- **ID**: TASK-027
- **Description**: Build reusable components (buttons, cards, inputs, etc.)
- **Dependencies**: TASK-026
- **Files**: `presentation/ui/components/`
- **Status**: Not Started

### 6.3 Implement Navigation
- **ID**: TASK-028
- **Description**: Set up Navigation Component with routes and navigation graph
- **Dependencies**: TASK-027
- **Files**: `presentation/navigation/NavGraph.kt`
- **Status**: Not Started

### 6.4 Add Animations and Transitions
- **ID**: TASK-029
- **Description**: Implement smooth animations and screen transitions
- **Dependencies**: TASK-028
- **Files**: `presentation/ui/animations/`
- **Status**: Not Started

### 6.5 Support Dark Mode
- **ID**: TASK-030
- **Description**: Implement dark theme support with system preference detection
- **Dependencies**: TASK-026
- **Files**: `presentation/ui/theme/DarkTheme.kt`
- **Status**: Not Started

## Phase 11: Security & Privacy

### 7.1 Implement Data Encryption
- **ID**: TASK-031
- **Description**: Encrypt all sensitive data at rest using AES-256
- **Dependencies**: TASK-007
- **Files**: Update encryption utilities
- **Status**: Not Started

### 7.2 Add Secure Key Management
- **ID**: TASK-032
- **Description**: Implement key rotation and secure key backup
- **Dependencies**: TASK-006
- **Files**: `data/local/keystore/KeyRotationManager.kt`
- **Status**: Not Started

### 7.3 Implement Secure Data Deletion
- **ID**: TASK-033
- **Description**: Add secure data deletion with overwrite
- **Dependencies**: TASK-005, TASK-008
- **Files**: `domain/usecases/SecureDeleteUseCase.kt`
- **Status**: Not Started

### 7.4 Create Privacy Settings
- **ID**: TASK-034
- **Description**: Build privacy settings screen with user controls
- **Dependencies**: TASK-008
- **Files**: `presentation/ui/screens/settings/PrivacySettingsScreen.kt`
- **Status**: Not Started

### 7.5 Security Audit
- **ID**: TASK-035
- **Description**: Conduct security audit and fix vulnerabilities
- **Dependencies**: All security tasks
- **Files**: Security audit report
- **Status**: Not Started

## Phase 12: Testing & Optimization

### 8.1 Write Unit Tests
- **ID**: TASK-036
- **Description**: Write unit tests for business logic and use cases
- **Dependencies**: Core features implemented
- **Files**: `test/` directory
- **Status**: Not Started

### 8.2 Write Integration Tests
- **ID**: TASK-037
- **Description**: Write integration tests for repositories and data operations
- **Dependencies**: TASK-036
- **Files**: `androidTest/` directory
- **Status**: Not Started

### 8.3 Write UI Tests
- **ID**: TASK-038
- **Description**: Write UI tests for critical user flows
- **Dependencies**: UI implementation complete
- **Files**: `androidTest/` directory
- **Status**: Not Started

### 8.4 Performance Optimization
- **ID**: TASK-039
- **Description**: Profile and optimize app performance
- **Dependencies**: All features implemented
- **Files**: Performance reports
- **Status**: Not Started

### 8.5 Memory Leak Detection
- **ID**: TASK-040
- **Description**: Detect and fix memory leaks
- **Dependencies**: TASK-039
- **Files**: Memory profiling reports
- **Status**: Not Started

## Phase 13: Polish & Release

### 9.1 Final UI/UX Polish
- **ID**: TASK-041
- **Description**: Final design review and UI improvements
- **Dependencies**: All UI tasks
- **Files**: UI components
- **Status**: Not Started

### 9.2 Accessibility Improvements
- **ID**: TASK-042
- **Description**: Add accessibility features (TalkBack, content descriptions)
- **Dependencies**: UI complete
- **Files**: UI components
- **Status**: Not Started

### 9.3 Internationalization
- **ID**: TASK-043
- **Description**: Add string resources and support multiple languages
- **Dependencies**: UI complete
- **Files**: `res/values/strings.xml`, `res/values-tr/strings.xml`
- **Status**: Not Started

### 9.4 Documentation
- **ID**: TASK-044
- **Description**: Write user documentation and developer documentation
- **Dependencies**: All features complete
- **Files**: `docs/` directory
- **Status**: Not Started

### 9.5 Release Preparation
- **ID**: TASK-045
- **Description**: Prepare for release (signing, ProGuard, versioning)
- **Dependencies**: All tasks complete
- **Files**: Release configuration
- **Status**: Not Started

## Task Dependencies Graph

```
Phase 1 → Phase 2 → Phase 3 → Phase 4 → Phase 5
                                    ↓
                              Phase 6 → Phase 7
                                    ↓
                              Phase 8 → Phase 9
```

## Parallel Execution Opportunities

Tasks that can be worked on in parallel (marked with [P]):

- TASK-011 and TASK-012 (different auth methods)
- TASK-021 and TASK-016 (data models)
- TASK-026 and TASK-027 (theme and components)
- TASK-036, TASK-037, TASK-038 (different test types)

## Checkpoints

After each phase, validate:
- ✅ All tasks completed
- ✅ Code compiles without errors
- ✅ Basic functionality works
- ✅ No critical security issues
- ✅ Code follows constitution principles

