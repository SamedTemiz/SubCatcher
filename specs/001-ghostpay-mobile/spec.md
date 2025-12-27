# SubCatcher Mobile Application - Specification

## Overview

**SubCatcher** is a privacy-focused subscription tracking and financial assistant application for Android. It automatically tracks digital subscriptions by analyzing bank notifications and screenshots without requiring bank account access. The application processes all data on-device and never transmits information to external servers.

**Motto**: "Görünmez Harcamaları Görünür Kılar" (Making Invisible Expenses Visible)

## Project Goals

1. Create a privacy-first subscription tracking application
2. Automatically detect subscriptions from bank notifications (zero user effort)
3. Process all operations on-device (zero data transmission)
4. Provide intelligent alerts before payments are charged
5. Help users identify and cancel forgotten subscriptions
6. Maintain complete user privacy and data security

## Core Value Proposition

**Problem**: Users lose money on forgotten subscriptions. Existing solutions either:
- Require bank account access (privacy concerns)
- Require manual entry (users give up after 3 subscriptions)

**Solution**: SubCatcher uses Notification Listener API and OCR to automatically track subscriptions without bank access, processing everything on-device.

## User Experience & Onboarding

### First Launch Experience
- **Welcome Screen**: User sees welcome screen with app introduction
- **Onboarding**: Single-screen onboarding with video/animation explaining key features
- **Permission Flow**: After onboarding, guide user through required permissions:
  1. Notification Listener permission (with animated explanation + step-by-step guide)
  2. Biometric authentication setup (optional but recommended)
  3. Optional: Screenshot access for initial data import

### Permission Explanations
- **Notification Listener**: 
  - Animated visual explanation showing how notifications are processed
  - Step-by-step guide with screenshots showing where to enable in Settings
  - Clear explanation: "We only read subscription-related notifications, no other data"

### Initial Data Collection Strategy
- **Option 1 (Recommended)**: User can choose to:
  - Start with zero data and wait for new notifications (passive mode)
  - OR upload screenshots to import existing subscriptions (active mode)
- **Option 2**: User can manually add subscriptions if preferred
- **Flexible Approach**: All three methods (notifications, screenshots, manual) available from start

### Error Handling & User Feedback

#### NLP Model Failures
- When NLP cannot extract data from notification:
  - Save notification text for user review
  - Show user: "Couldn't analyze this notification. Would you like to add it manually?"
  - User can edit and save manually

#### OCR Errors
- When OCR extracts incorrect data:
  - User can edit detected data before saving
  - User can retry OCR with same or different screenshot
  - Both editing and retry options available in confirmation screen

## User Stories

### 1. Automatic Notification Reading
- **As a user**, I want the app to automatically read bank notifications about subscription payments
- **As a user**, I want the app to extract subscription details (service name, amount, date) from notifications without manual input
- **As a user**, I want to grant notification access permission once and have the app work automatically

### 2. Screenshot-to-Sync (OCR)
- **As a user**, I want to upload a screenshot of my Play Store subscriptions page or bank transaction history
- **As a user**, I want the app to automatically extract all subscription information from the screenshot
- **As a user**, I want the app to ask for confirmation before saving detected subscriptions

### 3. Subscription Management
- **As a user**, I want to see all my active subscriptions in one place
- **As a user**, I want to see how long I've been paying for each subscription
- **As a user**, I want to see the annual cost of each subscription
- **As a user**, I want to filter and search my subscriptions

### 4. Smart Alerts & Warnings
- **As a user**, I want to be notified 24 hours before a subscription payment is charged
- **As a user**, I want to be notified if a subscription price increases
- **As a user**, I want to be warned about "ghost subscriptions" (paid for 3+ months with no usage)

### 5. Cancellation Assistant
- **As a user**, I want to tap "Cancel" button to be directed to the subscription management page
- **As a user**, I want step-by-step guides on how to cancel specific services
- **As a user**, I want to see cheaper alternatives to my current subscriptions

### 6. Privacy & Security
- **As a user**, I want assurance that no data leaves my device
- **As a user**, I want my bank details and transaction history to remain private
- **As a user**, I want to control what data is stored and delete it anytime

## Functional Requirements

### Must Have (MVP - Minimum Viable Product)

**Note**: MVP focuses on core functionality. Advanced features will be added in subsequent releases.

**MVP Core Features**:
- Both Notification Listener Service AND OCR (Screenshot Analysis) are required in MVP
- Support for all bank notification formats (general format parsing, not bank-specific)
- Turkish + English language support

#### 1. Notification Listener Service

#### 1. Notification Listener Service
- [ ] Android NotificationListenerService implementation
- [ ] Automatic bank notification detection and parsing
- [ ] NLP model to extract: merchant name, amount, currency, date
- [ ] Smart filtering (only subscription-related notifications)
- [ ] User permission flow with clear explanation

#### 2. OCR (Screenshot Analysis)
- [ ] Google ML Kit Text Recognition integration
- [ ] Screenshot upload from gallery or camera
- [ ] Play Store subscriptions page parsing
- [ ] Bank transaction history parsing
- [ ] SMS screenshot parsing
- [ ] Manual confirmation before saving detected subscriptions
- [ ] Image processing on-device (no upload)
- [ ] **Deferred**: Image cropping feature (process full image in MVP)

#### 3. Subscription Tracking
- [ ] Subscription entity model (name, amount, frequency, next payment date)
- [ ] Room database for local storage
- [ ] Subscription list UI with cards
- [ ] Timeline view (upcoming payments in next 30 days)
- [ ] Total monthly/annual cost calculation

#### 4. Alert System
- [ ] Push notifications 24 hours before payment
- [ ] Push notifications 1 hour before payment
- [ ] Price increase detection and alerts
- [ ] Ghost subscription detection (3+ months unused)

#### 5. Security & Privacy
- [ ] Biometric authentication (fingerprint/face)
- [ ] PIN/Password fallback
- [ ] Android Keystore for encryption
- [ ] All data encrypted at rest
- [ ] No external data transmission
- [ ] Privacy settings screen

#### 6. Basic UI
- [ ] Material Design 3 theme with custom colors/icons (SubCatcher branding)
- [ ] Dashboard with upcoming payments (main screen)
- [ ] Subscription library/list view
- [ ] Settings screen
- [ ] Onboarding flow
- [ ] Dark mode support (user selectable, not system-based)
- [ ] Hybrid navigation (Bottom navigation + Drawer for secondary features)

### Should Have
- [ ] Subscription categories (Entertainment, Productivity, etc.) - **Base Plan**
- [ ] Dark mode support - **Base Plan**
- [ ] Multi-language support (Turkish, English) - **Base Plan**
- [ ] Deep linking to subscription management pages - **Base Plan**

### Premium Features (Paid)
- [ ] Widget for home screen (customizable: upcoming payments + total monthly cost)
- [ ] Export subscriptions to CSV/PDF
- [ ] Price history charts (on-device)
- [ ] Advanced alert customization (custom times, multiple alerts)
- [ ] Annual cost analysis and projections
- [ ] Unlimited subscription tracking (Free plan: 5 subscriptions max)
- [ ] "Forget-Me-Not Insurance" - Automatic calendar reminders for cancellation

**Note**: Widget is a Premium feature but can be implemented in MVP or future release based on development priorities.

### Deferred to Future Releases
- [ ] Image cropping before OCR processing
- [ ] Export functionality (CSV/PDF) - **Deferred to post-MVP**
- [ ] Deep linking to cancellation pages - **Deferred to post-MVP**
- [ ] Advanced analytics dashboard (on-device)
- [ ] Customizable alert times (basic alerts in MVP)
- [ ] Recurring payment pattern detection
- [ ] Bundle recommendations (cheaper alternatives) - **Deferred per user request**
- [ ] Subscription sharing (export/import between devices via encrypted file)
- [ ] Backup to user's Google Drive/iCloud (encrypted)
- [ ] App Store screenshot support (for future iOS compatibility)
- [ ] General invoice image processing

## Non-Functional Requirements

### Performance
- App startup time: < 2 seconds
- Payment processing: < 1 second
- UI responsiveness: 60 FPS
- Memory usage: < 100MB average

### Security
- All data encrypted at rest
- Secure authentication required
- No external data transmission
- Secure key management using Android Keystore

### Privacy
- Zero external data transmission
- All processing on-device
- User data control
- Transparent privacy policy

### Compatibility
- Minimum Android 6.0 (API 23)
- Support for various screen sizes
- Tablet optimization
- Various device manufacturers

## Technical Implementation Details

### Notification Filtering Strategy

#### Notification Source Selection
- **Initial Approach**: Scan all notifications, filter subscription-related ones
- **User Control**: User can select which apps' notifications to monitor (practical solution needed)
- **First Setup**: User selects banks/apps during onboarding, can change later in settings
- **Smart Filtering**: NLP model automatically identifies subscription-related notifications using keywords

#### Non-Subscription Transaction Filtering
- **Hybrid Approach**: 
  - NLP model automatically filters using subscription keywords (Netflix, Spotify, iCloud, etc.)
  - If uncertain, ask user: "Is this a subscription?" (Yes/No)
  - User feedback improves model accuracy over time

### Subscription Detection Logic

#### Duplicate Service Handling
- **Same Service, Different Plans**: 
  - If multiple notifications for same service (e.g., Netflix Basic + Netflix Premium)
  - Ask user: "Is this the same subscription or different plan?"
  - Default: Treat as single subscription with highest amount
  - User can manually split if needed

#### Price Change Detection
- **Method**: Compare current payment with average of last 3 payments
- **Alert Threshold**: If price increase > 10%, notify user
- **Manual Override**: User can set fixed price mode if subscription has variable pricing

#### Cancellation Detection
- **Automatic**: If no notification received for 2-3 billing cycles, mark as "Likely Cancelled"
- **Manual**: User can mark subscription as "Cancelled" anytime
- **Status Options**: Active, Cancelled, Paused, Unknown

### OCR Screenshot Processing

#### Supported Formats (MVP)
- Play Store subscriptions page
- Bank mobile app transaction history
- SMS screenshots (bank notifications)
- **Future**: App Store (for iOS compatibility), general invoice images

#### Screenshot Processing Flow
- **Automatic Detection**: OCR extracts all subscription data from screenshot
- **User Confirmation**: Show detected subscriptions to user for review/confirmation
- **Batch Processing**: If multiple subscriptions detected, show all at once for bulk confirmation
- **Image Cropping**: **Deferred to future release** (MVP: process full image)

#### OCR Error Handling
- User can edit detected data before saving
- User can retry OCR with same or different screenshot
- Both editing and retry options available

## Technical Constraints

- **Platform**: Android only (native Kotlin)
- **Architecture**: Clean Architecture + MVVM
- **Storage**: Room Database for local data (encrypted)
- **Security**: Android Keystore for keys
- **UI**: Jetpack Compose (preferred) or XML layouts
- **Networking**: Zero external network calls (all processing on-device)
- **OCR**: Google ML Kit (on-device, no cloud)
- **NLP**: Custom trained model (TensorFlow Lite, on-device)
- **Background Processing**: WorkManager for reliable background tasks
- **Notification Access**: NotificationListenerService (requires special permission)

## Success Criteria

1. **Zero Data Transmission**: All operations process on-device, no external servers
2. **Automatic Detection**: Successfully detect 90%+ of subscription payments from notifications
3. **OCR Accuracy**: 95%+ accuracy in extracting subscription data from screenshots
4. **User Experience**: Users can set up tracking in under 2 minutes
5. **Privacy Compliance**: Full KVKK/GDPR compliance with on-device processing
6. **Performance**: App startup < 2 seconds, notification processing < 500ms
7. **Security**: All data encrypted, biometric authentication working
8. **User Satisfaction**: Users report saving money by canceling forgotten subscriptions

## Monetization Model

### Free Plan (Base Plan)
- **Subscription Limit**: Maximum 5 active subscriptions
- **Features Included**:
  - Automatic notification reading
  - OCR screenshot analysis
  - Basic subscription tracking
  - Basic alerts (24h and 1h before payment)
  - Price increase detection
  - Ghost subscription detection
  - Subscription categories
  - Dark mode
  - Multi-language support (Turkish, English)
  - Deep linking to cancellation pages

**Limit Enforcement**: When user tries to add 6th subscription, show "Upgrade to Premium" prompt with feature comparison.

### Premium Plan
- **Pricing Options**:
  - Monthly subscription
  - Annual subscription (with discount)
- **Features Included** (all Free features plus):
  - **Unlimited subscriptions**: No limit on tracked subscriptions
  - **Home screen widget**: Quick view of upcoming payments
  - **Export functionality**: CSV/PDF export of subscription data
  - **Price history charts**: Visual representation of price changes over time
  - **Advanced alerts**: Custom alert times, multiple alerts per subscription
  - **Annual cost analysis**: Detailed yearly spending projections
  - **Forget-Me-Not Insurance**: 
    - Automatic Google Calendar integration for cancellation reminders
    - In-app reminders for subscriptions user wants to cancel
    - Smart scheduling (reminds before next billing cycle)

**Premium Upgrade Triggers**:
- When attempting to add 6th subscription
- When trying to access premium-only features (widget, export, etc.)
- Strategic placement during natural usage flow (to be refined during development)

**Premium Purchase**:
- **Payment Method**: Google Play Billing (standard Android payment system)
- **Trial Period**: No free trial (users can use free plan to evaluate)
- **Pricing**: To be determined (not a technical requirement)

**Note**: Cheaper alternative recommendations feature is deferred to future release.

## MVP vs Future Releases

### MVP Focus
- **Core Functionality**: Get basic subscription tracking working reliably
- **Essential Features Only**: Notification reading, OCR, basic alerts, subscription list
- **Polish Later**: Advanced features, optimizations, and nice-to-haves in subsequent releases
- **User Feedback Driven**: Use MVP to gather feedback and prioritize future features

### Development Philosophy
- Start with fundamental features
- Add advanced features incrementally based on user needs
- Example: Image cropping is useful but not essential for MVP - can be added later

## Out of Scope (Initial Release)

- **Payment Processing**: App does NOT make payments, only tracks and alerts
- **iOS version**: Android-only for MVP
- **Cloud synchronization**: All data stays on-device
- **Social features**: No sharing or social integration
- **Bank account integration**: No direct bank API connections
- **Web application**: Mobile-only
- **Real-time bank sync**: Only notification-based tracking

## Legal & Compliance Notes

- **Not a Financial Advisor**: App provides information only, not financial advice
- **No Payment Processing**: App does not handle payments, only tracks them
- **KVKK/GDPR Compliance**: On-device processing ensures compliance

### Data Retention & Deletion
- **Default Retention**: 2 years (user can change in settings)
- **User Control**: User can set custom retention period or unlimited
- **Data Deletion**: 
  - User can delete individual subscriptions
  - User can delete all data via "Delete All Data" button in settings (GDPR compliance)
  - Deletion is permanent and cannot be undone
- **Backup Options** (Future Release):
  - Optional encrypted backup to user's Google Drive
  - User's own account, app only provides encryption key
  - Default: Data stays on device only (no backup)

### Permissions
- **Notification Listener**: Required for automatic subscription detection
- **Biometric**: Optional, for app security
- **Storage**: For screenshot processing (temporary, deleted after processing)
- **Internet**: Only for Google Play Billing (premium purchases)
- **No Analytics**: No internet permission for analytics or data transmission
- **Notification Permission**: Must clearly explain why notification access is needed
- **Data Minimization**: Only store subscription name, amount, date (no card numbers, balances)

## Testing & Quality Assurance

### Testing Strategy
- **Device Testing**: Test on various devices (Samsung, Xiaomi, Huawei, etc.) AND different Android versions (6.0, 8.0, 10, 12, 14)
- **Beta Testing**: 
  - Option 1: Open beta via Google Play Beta program
  - Option 2: Decision pending (to be determined)
- **Test User Count**: To be determined (decision pending)
- **Testing Phases**:
  1. Internal testing (development team)
  2. Closed beta (if applicable)
  3. Open beta (Google Play Beta)
  4. Production release

### Quality Metrics
- **NLP Accuracy**: Target 90%+ correct extraction from notifications
- **OCR Accuracy**: Target 95%+ correct extraction from screenshots
- **App Stability**: Zero crashes during normal usage
- **Performance**: App startup < 2 seconds, notification processing < 500ms
- **Battery Impact**: Minimal battery drain from background processing

## Future Considerations

- **iOS native version**: Notification access limitations on iOS
- **Advanced ML features**: Better pattern recognition for subscription detection
- **Widget improvements**: More customizable widgets
- **Export formats**: CSV/PDF export (deferred to post-MVP)
- **Deep linking**: Cancellation assistant with deep links (deferred to post-MVP)
- **Multi-device sync**: Encrypted file-based sync between user's own devices
- **Regional expansion**: Support for more banks and regions
- **Subscription marketplace**: Show cheaper alternatives (affiliate links)

