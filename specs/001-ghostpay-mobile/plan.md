# SubCatcher - Technical Implementation Plan

## Technology Stack

### Core Technologies
- **Language**: Kotlin 1.9+
- **Platform**: Android Native
- **Minimum SDK**: 23 (Android 6.0)
- **Target SDK**: Latest stable (34+)
- **Build System**: Gradle with Kotlin DSL

### Architecture
- **Pattern**: Clean Architecture + MVVM
- **Dependency Injection**: Hilt or Koin
- **Async Operations**: Kotlin Coroutines + Flow
- **UI Framework**: Jetpack Compose (preferred) or View System

### Core Libraries
- **Database**: Room Database 2.6.1+
- **Security**: Android Keystore System
- **Biometric**: AndroidX Biometric Library 1.1.0+
- **Navigation**: Navigation Component
- **OCR**: Google ML Kit Text Recognition v2 (on-device)
- **NLP**: TensorFlow Lite (custom trained model)
- **Background Tasks**: WorkManager
- **Notification Access**: NotificationListenerService
- **Encryption**: Android Security APIs (AES-256)

### Development Tools
- **IDE**: Android Studio
- **Version Control**: Git
- **CI/CD**: GitHub Actions (optional)
- **Testing**: JUnit, Espresso, Mockito

## Project Structure

```
app/
├── data/
│   ├── local/
│   │   ├── database/          # Room database
│   │   ├── preferences/       # SharedPreferences/DataStore
│   │   └── keystore/          # Secure key storage
│   └── models/                # Data models
├── domain/
│   ├── usecases/              # Business logic
│   ├── repositories/          # Repository interfaces
│   └── models/                # Domain models
├── presentation/
│   ├── ui/
│   │   ├── screens/           # Screen composables/activities
│   │   ├── components/        # Reusable UI components
│   │   └── theme/             # Material Design theme
│   ├── viewmodels/            # ViewModels
│   └── navigation/            # Navigation setup
└── di/                        # Dependency injection modules
```

## Implementation Phases

### Phase 1: Project Setup
1. Initialize Android project with Kotlin
2. Set up Gradle configuration
3. Configure dependency injection (Hilt)
4. Set up project structure (Clean Architecture)
5. Configure build variants (debug/release)
6. Add required dependencies (ML Kit, Room, WorkManager, etc.)

### Phase 2: Core Infrastructure
1. Set up Room database with encryption
2. Implement Android Keystore integration
3. Set up secure storage mechanisms (DataStore)
4. Configure encryption utilities (AES-256)
5. Set up on-device logging
6. Create data models (Subscription, Transaction, etc.)

### Phase 3: NLP Model Development
1. Collect bank notification templates (synthetic data generation)
2. Create training dataset (10,000+ samples)
3. Train NER model (Named Entity Recognition)
4. Convert model to TensorFlow Lite format
5. Integrate TFLite model into Android app
6. Test model accuracy with real notifications

### Phase 4: Notification Listener Service
1. Implement NotificationListenerService
2. Create notification filtering logic
3. Integrate NLP model for text parsing
4. Extract subscription data (merchant, amount, date)
5. Handle permission flow and user education
6. Test with various bank notification formats

### Phase 5: OCR (Screenshot Analysis)
1. Integrate Google ML Kit Text Recognition
2. Create screenshot upload UI
3. Implement image preprocessing
4. Extract text from screenshots
5. Parse Play Store subscriptions page format
6. Parse bank transaction history format
7. Create confirmation flow for detected subscriptions
8. Implement image deletion after processing

### Phase 6: Subscription Management
1. Design subscription data models
2. Implement Room entities and DAOs
3. Create subscription repository
4. Build subscription list UI
5. Create subscription detail screen
6. Implement subscription editing
7. Add subscription deletion with confirmation

### Phase 7: Alert & Notification System
1. Implement WorkManager for scheduled alerts
2. Create alert calculation logic (24h before, 1h before)
3. Implement price increase detection
4. Create ghost subscription detection (3+ months unused)
5. Build push notification system
6. Create notification settings UI
7. Test alert timing and accuracy

### Phase 8: Authentication & Security
1. Implement biometric authentication
2. Create PIN/Password authentication
3. Set up secure session management
4. Implement auto-lock after inactivity
5. Create authentication UI
6. Add authentication tests

### Phase 9: UI/UX Implementation
1. Implement Material Design 3 theme
2. Create dashboard with timeline view
3. Build subscription library/list view
4. Create settings screen
5. Implement onboarding flow
6. Add dark mode support
7. Create animations and transitions
8. Implement deep linking for cancellation

### Phase 10: Advanced Features
1. Implement widget for home screen
2. Create export functionality (CSV/PDF)
3. Add subscription categories
4. Implement price history tracking
5. Create cancellation guides
6. Add search and filtering

### Phase 6: UI/UX
1. Implement Material Design theme
2. Create reusable UI components
3. Implement navigation
4. Add animations and transitions
5. Support dark mode

### Phase 7: Security & Privacy
1. Implement data encryption
2. Add secure key management
3. Implement secure data deletion
4. Add privacy settings
5. Security audit and testing

### Phase 8: Testing & Optimization
1. Write unit tests
2. Write integration tests
3. Write UI tests
4. Performance optimization
5. Memory leak detection and fixes

### Phase 9: Polish & Release
1. Final UI/UX polish
2. Accessibility improvements
3. Internationalization
4. Documentation
5. Release preparation

## Data Flow

### Notification-Based Subscription Detection Flow
1. Bank sends notification about subscription payment
2. NotificationListenerService intercepts notification
3. Extract notification text using `Notification.EXTRA_TEXT`
4. NLP model processes text to extract: merchant, amount, currency, date
5. Validate extracted data (amount > 0, merchant not empty)
6. Check if subscription already exists
7. Save new subscription to Room database (encrypted)
8. Schedule alert for next payment date
9. Update UI if app is open

### Screenshot Analysis Flow
1. User uploads screenshot (Play Store subscriptions or bank history)
2. Google ML Kit processes image on-device
3. Extract all text with coordinates
4. Parse text to find subscription patterns:
   - Service name + price pairs
   - Date information
   - Recurring indicators
5. Present detected subscriptions to user for confirmation
6. User confirms/edits detected subscriptions
7. Save confirmed subscriptions to database
8. Delete screenshot from device (privacy)

### Alert Flow
1. WorkManager checks upcoming payments daily
2. Calculate days until next payment
3. If 24 hours before: Send notification "Payment tomorrow"
4. If 1 hour before: Send notification "Payment in 1 hour"
5. If price increased: Send notification "Price increased by X%"
6. If ghost subscription detected: Send notification "Haven't used this in 3 months"

### Data Storage
- **Subscription Data**: Encrypted in Room database
  - Service name, amount, frequency, next payment date
  - Payment history (encrypted)
- **User Preferences**: Encrypted DataStore
  - Alert preferences, theme, language
- **NLP Model**: Bundled in app assets (TensorFlow Lite)
- **No Cloud Storage**: All data remains on-device
- **No Sensitive Data**: Card numbers, balances never stored

## Security Architecture

### Key Management
- Use Android Keystore for cryptographic keys
- Keys never leave secure hardware (when available)
- Key rotation strategy for long-term security
- Secure key backup (encrypted, on-device only)

### Data Encryption
- AES-256-GCM encryption for sensitive data
- Room database encryption using SQLCipher
- Encrypted DataStore for preferences
- Secure inter-process communication
- Images deleted immediately after OCR processing

### Authentication
- Biometric authentication (fingerprint/face) - primary
- PIN/Password fallback - secondary
- Secure session tokens (on-device, encrypted)
- Auto-lock after inactivity (configurable timeout)
- App background detection and re-authentication

### Privacy Protection
- **Data Minimization**: Only store subscription name, amount, date
- **No Card Data**: Card numbers, CVV, balances never stored
- **No External Transmission**: All processing on-device
- **Notification Text**: Only subscription-related text processed, rest discarded
- **Image Processing**: Screenshots processed and deleted immediately
- **KVKK/GDPR Compliance**: On-device processing ensures compliance

## Performance Considerations

### Startup Optimization
- Lazy initialization
- Background thread initialization
- Minimal startup dependencies
- Optimized app size

### Memory Management
- Efficient data structures
- Proper lifecycle management
- Image caching (on-device)
- Memory leak prevention

### Battery Optimization
- Minimize background processing
- Efficient coroutine usage
- Battery-aware operations
- Doze mode compatibility

## Testing Strategy

### Unit Tests
- Business logic testing
- Use case testing
- Repository testing
- Utility function testing

### Integration Tests
- Database operations
- Security operations
- Payment processing flow
- Authentication flow

### UI Tests
- Critical user flows
- Screen navigation
- Form validation
- Error handling

## Deployment Strategy

### Build Variants
- **Debug**: Development and testing
- **Release**: Production build with ProGuard/R8

### Release Process
1. Internal testing
2. Beta testing (limited users)
3. Security audit
4. Production release
5. Post-release monitoring

## Risk Mitigation

### Technical Risks
- **Android version compatibility**: Test on multiple versions
- **Device-specific issues**: Test on various devices
- **Performance issues**: Continuous profiling
- **Security vulnerabilities**: Regular security audits

### Privacy Risks
- **Data leakage**: Comprehensive code review
- **Third-party libraries**: Audit all dependencies
- **System permissions**: Minimal permission requests
- **Background processing**: Careful background task management

## Success Metrics

### Technical Metrics
- **Zero external data transmission**: Verified through network monitoring
- **App startup**: < 2 seconds
- **Notification processing**: < 500ms from receipt to database save
- **OCR processing**: < 3 seconds for standard screenshot
- **NLP accuracy**: 90%+ correct extraction from notifications
- **Test coverage**: 80%+ code coverage
- **Memory usage**: < 100MB average
- **Battery impact**: Minimal (efficient background processing)

### User Experience Metrics
- **Setup time**: < 2 minutes from install to first subscription detected
- **Notification detection rate**: 90%+ of subscription payments detected
- **User satisfaction**: Positive feedback on privacy and automation
- **Subscription discovery**: Average user discovers 3-5 forgotten subscriptions
- **Money saved**: Users report saving money by canceling unused subscriptions

### Security Metrics
- **Zero critical security vulnerabilities**: Regular security audits
- **Encryption**: All sensitive data encrypted at rest
- **Authentication**: 100% of app access requires authentication
- **Privacy compliance**: Full KVKK/GDPR compliance

