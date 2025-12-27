# SubCatcher - Spec-Driven Development

This document serves as the central coordination point for Spec-Driven Development of the SubCatcher Android application.

## Project Overview

**SubCatcher** is a privacy-focused subscription tracking application built with native Android Kotlin. All data processing, notifications, and image handling must be performed on-device with no external server communication.

## Project Structure

```
SubCatcher/
├── app/                          # Android application (Kotlin)
│   ├── src/
│   ├── build.gradle.kts
│   └── ...
├── memory/
│   └── constitution.md          # Project principles and guidelines
├── specs/
│   └── 001-ghostpay-mobile/
│       ├── spec.md              # Feature specifications
│       ├── plan.md               # Technical implementation plan
│       ├── research.md           # Technology research
│       └── tasks.md              # Task breakdown
├── scripts/                      # Automation scripts
├── templates/                    # Spec templates
├── CLAUDE.md                     # This file
└── README.md                     # Project documentation
```

## Development Workflow

1. **Constitution** (`/speckit.constitution`) - Define project principles
2. **Specify** (`/speckit.specify`) - Create feature specifications
3. **Plan** (`/speckit.plan`) - Generate technical implementation plan
4. **Research** - Investigate technologies and best practices
5. **Tasks** (`/speckit.tasks`) - Break down into actionable tasks
6. **Implement** (`/speckit.implement`) - Execute implementation

## Key Principles

- **Privacy First**: All processing on-device, no external data transmission
- **Native Android**: Kotlin-based native development
- **Security**: End-to-end encryption, secure storage
- **Performance**: Optimized for mobile devices

## Current Status

- [x] Project structure initialized
- [ ] Constitution defined
- [ ] Specifications created
- [ ] Implementation plan ready
- [ ] Research completed
- [ ] Tasks defined
- [ ] Implementation started

