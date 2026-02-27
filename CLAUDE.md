# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run Commands

```bash
# Build executable uber-JAR (via Maven wrapper, requires Java 21)
./mvnw clean package

# Run all tests and verification (used in CI)
./mvnw verify

# Run a single test class
./mvnw test -pl . -Dtest=MyTestClass

# Run locally
java -jar target/armeria-rest-example.jar

# Docker build and run
make up          # builds JAR, Docker image, and runs container
make dist        # just build JAR
make image       # just build Docker image
```

## Architecture

This is a minimal REST API built with **Armeria** (async HTTP framework) on **Java 25**.

**Single entry point:** `armeria.rest.example.App` — configures an Armeria `Server` with annotated REST services and starts it on port 8080. Services are defined as anonymous inner classes using Armeria's `@Get`/`@Produces` annotations.

**Key dependencies:** Armeria for HTTP serving, GSON for JSON serialization, Logback for logging.

**Deployment:** Dockerfile uses multi-stage build with Ubuntu 24.04 + OpenJDK 21 JRE, runs as non-root `app` user. Helm charts in `deployment/k8s/helm/` provide Kubernetes manifests (Deployment, Service, Ingress, HPA, RBAC).

**CI:** GitHub Actions (`.github/workflows/build.yml`) runs `mvn verify` on push/PR to main, then builds and pushes Docker image on main branch merges.
