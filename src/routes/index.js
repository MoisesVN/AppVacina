import { NavigationContainer } from '@react-navigation/native';

import TabRoutes from './tab.routes';
import AuthProvider from '../context/auth';

export default function Routes() {
    return (
        <NavigationContainer>
            <AuthProvider>
                <TabRoutes />
            </AuthProvider>
        </NavigationContainer>
    )
}