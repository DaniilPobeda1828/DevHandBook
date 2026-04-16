import java.util.LinkedHashMap;
import java.util.Map;

public class DataProvider {

    // ============================================================
    // ЯЗЫКИ ПРОГРАММИРОВАНИЯ И ФРЕЙМВОРКИ
    // ============================================================

    public static Map<String, String> getLanguagesData() {
        Map<String, String> data = new LinkedHashMap<>();

        // ==================== PYTHON ====================
        data.put("Python", """
            
            ================================================================================
            PYTHON - УСТАНОВКА
            ================================================================================

            СПОСОБЫ УСТАНОВКИ:
            
            Windows:
                1. Перейдите на https://www.python.org/downloads/
                2. Скачайте последнюю стабильную версию (3.12+)
                3. ВАЖНО: Обязательно отметьте "Add Python to PATH"
                4. Выберите "Install Now"
                5. Дождитесь завершения установки
                6. Проверка: Win+R → cmd → python --version
            
            macOS:
                - Через Homebrew: brew install python
                - Или скачайте установщик с python.org
                - Проверка: python3 --version
            
            Linux (Ubuntu/Debian):
                sudo apt update
                sudo apt install python3 python3-pip
                python3 --version
            
            ПОЛЕЗНЫЕ ИНСТРУМЕНТЫ:
                - pyenv — управление разными версиями Python
                - virtualenv / venv — виртуальные окружения
                - pip — менеджер пакетов
            
            """);

        // ==================== JAVA ====================
        data.put("Java", """
            
            ================================================================================
            JAVA - УСТАНОВКА JDK
            ================================================================================

            ИСТОЧНИКИ ДЛЯ СКАЧИВАНИЯ:
                - Adoptium (Eclipse Temurin): https://adoptium.net/
                - Oracle JDK: https://www.oracle.com/java/technologies/downloads/
                - OpenJDK: https://openjdk.org/
                - Amazon Corretto: https://aws.amazon.com/corretto/
            
            Windows:
                1. Скачайте MSI установщик (рекомендуется LTS версия, например JDK 21)
                2. Запустите и запомните путь (например, C:\\Program Files\\Java\\jdk-21)
                3. Настройте переменные окружения:
                   - JAVA_HOME = C:\\Program Files\\Java\\jdk-21
                   - Добавьте %JAVA_HOME%\\bin в PATH
                4. Проверка: java -version и javac -version
            
            macOS:
                brew install openjdk@21
                sudo ln -sfn $(brew --prefix)/opt/openjdk@21/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-21.jdk
            
            Linux:
                - Ubuntu/Debian: sudo apt install openjdk-21-jdk
                - Fedora: sudo dnf install java-21-openjdk-devel
                - Arch: sudo pacman -S jdk21-openjdk
            
            """);

        // ==================== NODE.JS ====================
        data.put("Node.js", """
            
            ================================================================================
            NODE.JS - УСТАНОВКА
            ================================================================================

            Официальный установщик:
                1. Сайт: https://nodejs.org/
                2. Выбирайте LTS версию (стабильная, долгосрочная поддержка)
                3. Запустите установщик
                4. Убедитесь, что npm устанавливается автоматически
                5. Проверка: node --version && npm --version
            
            Через менеджер версий nvm (рекомендуется):
                curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.7/install.sh | bash
                nvm install --lts
                nvm use --lts
            
            macOS / Linux:
                - macOS: brew install node
                - Ubuntu: curl -fsSL https://deb.nodesource.com/setup_20.x | sudo -E bash - && sudo apt install -y nodejs
            
            """);

        // ==================== C/C++ ====================
        data.put("C/C++", """
            
            ================================================================================
            C/C++ - УСТАНОВКА КОМПИЛЯТОРА
            ================================================================================

            Windows (MinGW-w64):
                1. Скачайте MSYS2: https://www.msys2.org/
                2. Запустите установку
                3. Откройте MSYS2 UCRT64
                4. Выполните: pacman -S mingw-w64-ucrt-x86_64-gcc
                5. Добавьте в PATH: C:\\msys64\\ucrt64\\bin
            
            Windows (Visual Studio):
                1. Скачайте Visual Studio Community
                2. Выберите "Desktop development with C++"
                3. Используйте "Developer Command Prompt" для компиляции
            
            Linux:
                sudo apt install build-essential gdb
            
            macOS:
                xcode-select --install
            
            """);

        // ==================== GO ====================
        data.put("Go", """
            
            ================================================================================
            GO (GOLANG) - УСТАНОВКА
            ================================================================================

            Официальный сайт: https://go.dev/dl/
            
            Windows / macOS:
                1. Скачайте установщик
                2. Запустите и следуйте инструкциям
                3. Проверка: go version
            
            Linux:
                wget https://go.dev/dl/go1.21.5.linux-amd64.tar.gz
                sudo tar -C /usr/local -xzf go1.21.5.linux-amd64.tar.gz
                export PATH=$PATH:/usr/local/go/bin
            
            Настройка workspace:
                mkdir ~/go
                export GOPATH=~/go
                export PATH=$PATH:$GOPATH/bin
            
            """);

        // ==================== RUST ====================
        data.put("Rust", """
            
            ================================================================================
            RUST - УСТАНОВКА
            ================================================================================

            Рекомендуемый способ (rustup):
                curl --proto '=https' --tlsv1.2 -sSf https://sh.rustup.rs | sh
                (Выберите вариант 1 — стандартная установка)
            
            После установки:
                source ~/.cargo/env
                rustc --version
                cargo --version
            
            Windows:
                Скачайте rustup-init.exe с https://rustup.rs/
            
            Обновление и удаление:
                - Обновление: rustup update
                - Удаление: rustup self uninstall
            
            """);

        // ==================== PHP ====================
        data.put("PHP", """
            
            ================================================================================
            PHP - УСТАНОВКА
            ================================================================================

            Windows:
                1. Скачайте с https://windows.php.net/download/
                2. Распакуйте в C:\\php
                3. Добавьте C:\\php в PATH
                4. Скопируйте php.ini-development → php.ini
            
            macOS:
                brew install php
            
            Linux (Ubuntu):
                sudo apt update
                sudo apt install php php-cli php-fpm php-mysql php-curl php-json
                php -v
            
            Встроенный веб-сервер:
                php -S localhost:8000
            
            """);

        // ==================== REACT ====================
        data.put("React", """
            
            ================================================================================
            REACT - УСТАНОВКА
            ================================================================================

            ПРЕДВАРИТЕЛЬНЫЕ ТРЕБОВАНИЯ:
                Перед установкой React убедитесь, что у вас установлен Node.js (версия 14+):
                node --version
                npm --version
            
            СПОСОБ 1: CREATE REACT APP (рекомендуется для начинающих)
                npx create-react-app my-app
                cd my-app
                npm start
                
                Команды:
                npm start        # Запуск в режиме разработки (http://localhost:3000)
                npm test         # Запуск тестов
                npm run build    # Сборка для production (папка build/)
            
            СПОСОБ 2: VITE (быстрее, рекомендуется для опытных)
                npm create vite@latest my-app -- --template react
                cd my-app
                npm install
                npm run dev
            
            СПОСОБ 3: NEXT.JS (для производственных проектов)
                npx create-next-app@latest my-app
                cd my-app
                npm run dev
                Откройте http://localhost:3000
            
            Установка в существующий проект:
                npm install react react-dom
                npm install --save-dev @vitejs/plugin-react
            
            ПОЛЕЗНЫЕ КОМАНДЫ:
                npm install react-router-dom        # Маршрутизация
                npm install axios                   # HTTP-запросы
                npm install redux react-redux       # Управление состоянием
                npm install tailwindcss             # CSS-фреймворк
            
            СТРУКТУРА ПРОЕКТА (Create React App):
                my-app/
                |-- public/
                |   |-- index.html
                |-- src/
                |   |-- App.js
                |   |-- App.css
                |   |-- index.js
                |   |-- index.css
                |-- package.json
                |-- README.md
            
            СОВЕТЫ:
                - Для изучения React начните с Create React App
                - Для быстрой разработки используйте Vite
                - Для SEO-проектов выбирайте Next.js
                - Используйте React DevTools в браузере для отладки
            
            """);

        return data;
    }

    // ============================================================
    // МЕНЕДЖЕРЫ БИБЛИОТЕК
    // ============================================================

    public static Map<String, String> getLibrariesData() {
        Map<String, String> data = new LinkedHashMap<>();

        data.put("pip (Python)", """
            
            ================================================================================
            PIP (PYTHON) - МЕНЕДЖЕР ПАКЕТОВ
            ================================================================================

            ОСНОВНЫЕ КОМАНДЫ:
                pip install <package>              # установка пакета
                pip install <package>==1.2.3       # установка конкретной версии
                pip install --upgrade <package>    # обновление пакета
                pip uninstall <package>            # удаление пакета
                pip list                           # список установленных пакетов
                pip show <package>                 # информация о пакете
                pip freeze > requirements.txt      # сохранить зависимости в файл
                pip install -r requirements.txt    # установить зависимости из файла
            
            """);

        data.put("npm (Node.js)", """
            
            ================================================================================
            NPM (NODE.JS) - МЕНЕДЖЕР ПАКЕТОВ
            ================================================================================

            ОСНОВНЫЕ КОМАНДЫ:
                npm init -y                      # создать package.json
                npm install <package>            # локальная установка
                npm install -g <package>         # глобальная установка
                npm install                      # установка всех зависимостей
                npm install --save-dev <package> # dev-зависимость
                npm uninstall <package>          # удаление
                npm update                       # обновление
                npm run <script>                 # запуск скрипта
            
            """);

        data.put("yarn (Node.js)", """
            
            ================================================================================
            YARN (NODE.JS) - МЕНЕДЖЕР ПАКЕТОВ
            ================================================================================

            УСТАНОВКА:
                npm install -g yarn
                Или скачайте с https://yarnpkg.com/
            
            ОСНОВНЫЕ КОМАНДЫ:
                yarn init                       # создать package.json
                yarn add <package>              # добавить зависимость
                yarn add --dev <package>        # dev-зависимость
                yarn add -g <package>           # глобальная установка
                yarn install                    # установка всех зависимостей
                yarn remove <package>           # удалить зависимость
                yarn upgrade                    # обновить зависимости
                yarn run <script>               # запустить скрипт
            
            """);

        data.put("pnpm (Node.js)", """
            
            ================================================================================
            PNPM (NODE.JS) - МЕНЕДЖЕР ПАКЕТОВ
            ================================================================================

            УСТАНОВКА:
                npm install -g pnpm
                Или скачайте с https://pnpm.io/
            
            ОСНОВНЫЕ КОМАНДЫ:
                pnpm init                       # создать package.json
                pnpm add <package>              # добавить зависимость
                pnpm add --dev <package>        # dev-зависимость
                pnpm install                    # установка всех зависимостей
                pnpm remove <package>           # удалить зависимость
                pnpm update                     # обновить зависимости
                pnpm run <script>               # запустить скрипт
            
            Преимущество: экономит место на диске (использует жёсткие ссылки)
            
            """);

        data.put("cargo (Rust)", """
            
            ================================================================================
            CARGO (RUST) - СБОРЩИК И МЕНЕДЖЕР ПАКЕТОВ
            ================================================================================

            ОСНОВНЫЕ КОМАНДЫ:
                cargo new myproject       # создать новый проект
                cargo build               # скомпилировать проект
                cargo run                 # скомпилировать и запустить
                cargo check               # проверить код без компиляции
                cargo test                # запустить тесты
                cargo add <package>       # добавить зависимость
                cargo update              # обновить зависимости
                cargo doc --open          # открыть документацию
            
            """);

        data.put("composer (PHP)", """
            
            ================================================================================
            COMPOSER (PHP) - МЕНЕДЖЕР ЗАВИСИМОСТЕЙ
            ================================================================================

            УСТАНОВКА:
                php -r "copy('https://getcomposer.org/installer', 'composer-setup.php');"
                php composer-setup.php
                php -r "unlink('composer-setup.php');"
                mv composer.phar /usr/local/bin/composer
            
            ОСНОВНЫЕ КОМАНДЫ:
                composer init                # создать composer.json
                composer require <package>   # добавить зависимость
                composer install             # установить все зависимости
                composer update              # обновить зависимости
                composer remove <package>    # удалить зависимость
                composer show                # показать установленные пакеты
            
            """);

        return data;
    }

    // ============================================================
    // ОШИБКИ
    // ============================================================

    public static Map<String, String> getErrorsData() {
        Map<String, String> data = new LinkedHashMap<>();

        data.put("ModuleNotFoundError / ImportError", """
            
            ================================================================================
            PYTHON: МОДУЛЬ НЕ НАЙДЕН
            ================================================================================

            ПРИЧИНЫ:
                1. Библиотека не установлена в системе
                2. Неправильное имя при импорте (регистр имеет значение)
                3. Виртуальное окружение не активировано
                4. Свой собственный модуль не в PYTHONPATH
            
            РЕШЕНИЯ:
                - Установите библиотеку: pip install <module_name>
                - Проверьте правильность написания имени
                - Активируйте виртуальное окружение
                - Добавьте путь к своему модулю: sys.path.append('/path/to/module')
            
            """);

        data.put("SyntaxError / IndentationError", """
            
            ================================================================================
            PYTHON: ОШИБКА СИНТАКСИСА ИЛИ ОТСТУПОВ
            ================================================================================

            ПРИЧИНЫ:
                - Пропущено двоеточие после if, for, def, class
                - Смешивание табуляции и пробелов
                - Незакрытые скобки: (, [, {
                - Пропущены кавычки в строке
            
            РЕШЕНИЯ:
                1. Настройте редактор на использование 4 пробелов
                2. Проверьте все двоеточия в конструкциях
                3. Используйте IDE с подсветкой синтаксиса
                4. Для поиска ошибок: python -m py_compile script.py
            
            """);

        data.put("'npm ERR! missing script: start'", """
            
            ================================================================================
            REACT / NODE.JS: ОТСУТСТВУЕТ СКРИПТ START
            ================================================================================

            ПРИЧИНА:
                В файле package.json отсутствует скрипт "start"
            
            РЕШЕНИЯ:
                1. Убедитесь, что вы находитесь в правильной директории проекта
                2. Добавьте скрипт в package.json:
                   "scripts": {
                     "start": "react-scripts start"
                   }
                3. Или используйте команду: npm run build (если проект уже собран)
                4. Для Create React App переустановите зависимости: npm install
            
            """);

        data.put("React: 'Cannot find module'", """
            
            ================================================================================
            REACT: МОДУЛЬ НЕ НАЙДЕН
            ================================================================================

            ПРИЧИНЫ:
                - Модуль не установлен
                - Неправильный путь импорта
                - Опечатка в имени модуля
            
            РЕШЕНИЯ:
                - Установите модуль: npm install <module-name>
                - Проверьте путь к файлу: import MyComponent from './components/MyComponent'
                - Очистите кэш npm: npm cache clean --force
                - Удалите node_modules и установите заново: rm -rf node_modules && npm install
            
            """);

        data.put("npm: command not found", """
            
            ================================================================================
            NPM НЕ НАЙДЕН
            ================================================================================

            ПРИЧИНЫ:
                - Node.js установлен, но npm не установлен вместе с ним
                - npm не добавлен в PATH
            
            РЕШЕНИЯ:
                1. Переустановите Node.js с официального сайта
                2. Проверьте установку: where node (Windows) или which node (Linux/macOS)
                3. Добавьте в PATH папку с npm
                4. Используйте npx как альтернативу
            
            """);

        data.put("Permission denied при установке", """
            
            ================================================================================
            ОШИБКА ДОСТУПА ПРИ УСТАНОВКЕ
            ================================================================================

            ПРИЧИНА:
                Недостаточно прав для установки пакета в системную папку
            
            РЕШЕНИЯ:
                1. Установите для пользователя: npm install --save-dev <package>
                2. Используйте npx без установки: npx <package>
                3. На Linux/macOS: sudo npm install (НЕ РЕКОМЕНДУЕТСЯ)
                4. На Windows: запустите терминал от имени администратора
            
            """);

        data.put("Общие советы по отладке", """
            
            ================================================================================
            ОБЩИЕ СОВЕТЫ ПО ОТЛАДКЕ
            ================================================================================

                1. ВСЕГДА читайте первую ошибку — она самая важная
                2. Проверьте версии: python --version, node --version, java -version
                3. Копируйте ошибку в Google / StackOverflow
                4. Проверьте пути и переменные окружения
                5. Используйте виртуальные окружения для изоляции
                6. Обновите инструменты: npm update -g npm
                7. Перезапустите терминал / IDE после установки
                8. Проверьте права доступа к файлам и папкам
            
            """);

        return data;
    }
}