# SubCatcher Project Constitution

## Core Principles

### 1. Privacy and Security
- **On-Device Processing**: All data processing, notifications, and image handling must occur on-device
- **No External Transmission**: No data (notifications, images, or user data) should be sent to external servers
- **Local Storage**: All sensitive data must be stored securely on-device using Android's secure storage mechanisms
- **Encryption**: Implement end-to-end encryption for all stored data

### 2. Technology Stack
- **Platform**: Native Android (Kotlin)
- **Minimum SDK**: Android API 23 (Android 6.0)
- **Target SDK**: Latest stable Android version
- **Architecture**: Clean Architecture with MVVM pattern
- **Language**: Kotlin 100%

### 3. Code Quality Standards
- **DRY Principle**: Don't Repeat Yourself - eliminate code duplication
- **SOLID Principles**: Follow all SOLID principles for maintainable code
- **Clean Code**: Write readable, self-documenting code
- **Type Safety**: Leverage Kotlin's type system fully
- **Functional Programming**: Prefer functional and declarative patterns over imperative

### 4. Development Practices
- **Component-Based Development**: Build reusable, modular components
- **Test-Driven Development**: Write tests before implementation where applicable
- **Documentation**: All code must include comprehensive comments and documentation
- **No TODOs**: Complete all implementations, no placeholder code
- **Error Handling**: Comprehensive error handling for all edge cases

### 5. Performance Requirements
- **Startup Time**: App should launch within 2 seconds
- **Memory Usage**: Optimize memory footprint for mobile devices
- **Battery Efficiency**: Minimize background processing
- **Network Efficiency**: Minimize network calls (on-device processing preferred)

### 6. User Experience
- **Material Design**: Follow Android Material Design guidelines
- **Accessibility**: Support accessibility features (TalkBack, etc.)
- **Internationalization**: Support multiple languages
- **Responsive Design**: Support various screen sizes and orientations

### 7. Security Requirements
- **Secure Storage**: Use Android Keystore for sensitive data
- **Biometric Authentication**: Support fingerprint/face unlock where available
- **Data Encryption**: Encrypt all sensitive data at rest
- **Secure Communication**: Use HTTPS/TLS for any necessary network communication
- **Input Validation**: Validate and sanitize all user inputs

### 8. Architecture Guidelines
- **Separation of Concerns**: Clear separation between UI, business logic, and data layers
- **Dependency Injection**: Use dependency injection for testability
- **Reactive Programming**: Use Kotlin Coroutines and Flow for asynchronous operations
- **State Management**: Proper state management for UI components

### 9. Testing Standards
- **Unit Tests**: Critical business logic must have unit tests
- **Integration Tests**: Test component interactions
- **UI Tests**: Test critical user flows
- **Test Coverage**: Aim for 80%+ code coverage

### 10. Documentation Requirements
- **Code Comments**: All functions and classes must have documentation comments
- **API Documentation**: Document all public APIs
- **Architecture Documentation**: Maintain architecture decision records
- **User Documentation**: Provide clear user guides

## Prohibited Practices

- ❌ Sending any data to external servers
- ❌ Using third-party analytics that transmit data externally
- ❌ Storing sensitive data in plain text
- ❌ Leaving TODO comments in production code
- ❌ Using deprecated Android APIs
- ❌ Ignoring security warnings
- ❌ Hardcoding sensitive values

## Required Practices

- ✅ On-device processing for all operations
- ✅ Secure storage for sensitive data
- ✅ Comprehensive error handling
- ✅ Full code documentation
- ✅ Type-safe code with Kotlin
- ✅ Following Material Design guidelines
- ✅ Testing critical paths
- ✅ Privacy-first approach

